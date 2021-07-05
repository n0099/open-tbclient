package d.b.c.b.a;

import android.app.ActivityManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, processErrorStateInfo)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("|------------- processErrorStateInfo--------------|\n");
            sb.append("condition: " + processErrorStateInfo.condition + "\n");
            sb.append("processName: " + processErrorStateInfo.processName + "\n");
            sb.append("pid: " + processErrorStateInfo.pid + "\n");
            sb.append("uid: " + processErrorStateInfo.uid + "\n");
            sb.append("tag: " + processErrorStateInfo.tag + "\n");
            sb.append("shortMsg : " + processErrorStateInfo.shortMsg + "\n");
            sb.append("longMsg : " + processErrorStateInfo.longMsg + "\n");
            sb.append("-----------------------end----------------------------");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
