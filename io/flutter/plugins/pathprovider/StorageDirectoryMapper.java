package io.flutter.plugins.pathprovider;

import android.os.Build;
import android.os.Environment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class StorageDirectoryMapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StorageDirectoryMapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String androidType(Integer num) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, num)) == null) {
            if (num == null) {
                return null;
            }
            switch (num.intValue()) {
                case 0:
                    return Environment.DIRECTORY_MUSIC;
                case 1:
                    return Environment.DIRECTORY_PODCASTS;
                case 2:
                    return Environment.DIRECTORY_RINGTONES;
                case 3:
                    return Environment.DIRECTORY_ALARMS;
                case 4:
                    return Environment.DIRECTORY_NOTIFICATIONS;
                case 5:
                    return Environment.DIRECTORY_PICTURES;
                case 6:
                    return Environment.DIRECTORY_MOVIES;
                case 7:
                    return Environment.DIRECTORY_DOWNLOADS;
                case 8:
                    return Environment.DIRECTORY_DCIM;
                case 9:
                    if (Build.VERSION.SDK_INT >= 19) {
                        return Environment.DIRECTORY_DOCUMENTS;
                    }
                    throw new IllegalArgumentException("Documents directory is unsupported.");
                default:
                    throw new IllegalArgumentException("Unknown index: " + num);
            }
        }
        return (String) invokeL.objValue;
    }
}
