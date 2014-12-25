package name.tanglei.airplaneswitcher.ui;

import java.util.List;

import name.tanglei.airplaneswitcher.R;
import name.tanglei.airplaneswitcher.entity.TaskEntity;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class TaskListAdapter extends ArrayAdapter<TaskEntity>
{
    public TaskListAdapter(Activity activity, List<TaskEntity> list)
    {
        super(activity, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = ((Activity) this.getContext())
                .getLayoutInflater();
        //rowView = inflater.inflate(R.layout.task_item, null);
        View rowView = inflater.inflate(R.layout.row_alarm, null);
        TaskEntity task = this.getItem(position);

        TextView timeView = (TextView) rowView
        //        .findViewById(R.id.idTime);
                    .findViewById(R.id.alarm_line_alarm_hour);
        timeView.setText(task.getTimeStr(this.getContext()));

        TextView modeOn = (TextView) rowView
                //.findViewById(R.id.idModeOn);
                .findViewById(R.id.alarm_line_alarm_wake_type);
        String modeOnDesc = task.isModeOn() ? this.getContext().getString(R.string.txtTypeOpen)
                                    : this.getContext().getString(R.string.txtTypeClosed);
        modeOn.setTextColor(task.isModeOn() ? this.getContext().getResources().getColor(R.color.GREEN)
                                            :  this.getContext().getResources().getColor(R.color.RED));
        modeOn.setText(modeOnDesc);
        //TextView txRepeat = (TextView)rowView.findViewById(R.id.idRepeat);
        TextView txRepeat = (TextView)rowView.findViewById(R.id.alarm_line_alarm_weekdays);
        String repeatDesc = task.getRepeatStr(this.getContext());
        txRepeat.setText(repeatDesc);

        //TextView txTitle = (TextView)rowView.findViewById(R.id.idTaskDesc);
        TextView txTitle = (TextView)rowView.findViewById(R.id.alarm_line_alarm_name);
        txTitle.setText(task.getTitle());

        //ToggleButton tgButton = (ToggleButton)rowView.findViewById(R.id.idTgButton);
        //tgButton.setChecked(task.isActive());

        CheckBox chk = (CheckBox)rowView.findViewById(R.id.alarm_line_alarm_is_active);
        chk.setChecked(task.isActive());

        return rowView;
    }


}