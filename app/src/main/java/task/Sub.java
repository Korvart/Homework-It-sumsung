package task;

import android.content.Context;
import android.widget.Toast;

public class Sub {
    public static void show(Context context, String message)
    {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }

}