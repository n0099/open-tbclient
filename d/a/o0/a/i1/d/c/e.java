package d.a.o0.a.i1.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MediaModel> f46014a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || (arrayList = f46014a) == null) {
            return;
        }
        arrayList.clear();
        f46014a = null;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ArrayList<MediaModel> arrayList = f46014a;
            if (arrayList == null || arrayList.size() == 0 || f46014a.get(0) == null) {
                return null;
            }
            return f46014a.get(0).getType();
        }
        return (String) invokeV.objValue;
    }

    public static int c(MediaModel mediaModel) {
        InterceptResult invokeL;
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mediaModel)) == null) {
            if (mediaModel == null || (arrayList = f46014a) == null) {
                return -1;
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (mediaModel.equals(f46014a.get(i2))) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ArrayList<MediaModel> arrayList = f46014a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public static ArrayList<MediaModel> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f46014a : (ArrayList) invokeV.objValue;
    }

    public static boolean f(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, mediaModel)) == null) {
            ArrayList<MediaModel> arrayList = f46014a;
            if (arrayList == null) {
                return false;
            }
            return arrayList.contains(mediaModel);
        }
        return invokeL.booleanValue;
    }

    public static boolean g(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, mediaModel)) == null) {
            ArrayList<MediaModel> arrayList = f46014a;
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            return f46014a.contains(mediaModel);
        }
        return invokeL.booleanValue;
    }

    public static void h(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, mediaModel) == null) || (arrayList = f46014a) == null) {
            return;
        }
        arrayList.remove(mediaModel);
    }

    public static void i(MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, mediaModel) == null) || mediaModel == null) {
            return;
        }
        if (f46014a == null) {
            f46014a = new ArrayList<>();
        }
        f46014a.add(mediaModel);
    }
}
