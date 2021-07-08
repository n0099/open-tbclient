package d.a.o0.r.x;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStaticClassesArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String[] f52990a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f52991b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(642170580, "Ld/a/o0/r/x/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(642170580, "Ld/a/o0/r/x/d;");
                return;
            }
        }
        f52990a = new String[]{"com.baidu.tieba.livesdk.AlaLiveSdkStatic", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", "com.baidu.tieba.advert.sdk.AdvertSDKStatic", "com.baidu.tieba.funad.FunAdStatic", "com.baidu.tieba.recapp.lego.RecAppLegoStatic", "com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic", "com.baidu.tbadk.core.LaunchStatic", "com.baidu.tieba.wallet.PayStatic", "com.baidu.tieba.emotion.BasePlugInFaceProviderStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.im.TiebaIMActivityStatic", "com.baidu.tbadk.plugins.Static", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic", "com.baidu.tieba.personCenter.PersonInfoDelegateStatic", "com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic", "com.baidu.tieba.location.LocationProvidersStatic", "com.baidu.tieba.ala.livecard.Static", "com.baidu.tieba.emotion.PlugInFaceProviderStatic", "com.baidu.tieba.flutter.FlutterStatic"};
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                TiebaStaticClassesArray tiebaStaticClassesArray = new TiebaStaticClassesArray();
                boolean z = true;
                try {
                    Class<?> cls = Class.forName("com.baidu.tbadk.core.util.TiebaStaticArray");
                    Object newInstance = cls.newInstance();
                    Field declaredField = cls.getDeclaredField("staticClassesArray");
                    declaredField.setAccessible(true);
                    tiebaStaticClassesArray.staticClassesArray = (String[]) declaredField.get(newInstance);
                } catch (Exception e2) {
                    Log.e("staticClassesArray: ", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    e2.printStackTrace();
                }
                Log.e("staticClassesArray: ", "" + tiebaStaticClassesArray.staticClassesArray.length);
                if (d.a.o0.r.d0.b.j().k("static_opt_open", 0) <= 0) {
                    z = false;
                }
                f52991b = z;
                long currentTimeMillis = System.currentTimeMillis();
                if (f52991b) {
                    if (b()) {
                        MultiDexHelper.loadClass(BdBaseApplication.getInst());
                    } else {
                        Log.e("TiebaStaticClassesArray", "load from dex fail ");
                        if (!tiebaStaticClassesArray.loadStaticClasses()) {
                            MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
                        }
                    }
                } else if (!tiebaStaticClassesArray.loadStaticClasses()) {
                    MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
                }
                Log.e("Tasks", "load from dex coast time " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                if (f52990a.length <= 0) {
                    return false;
                }
                for (String str : f52990a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Class.forName(str);
                    Log.e("TiebaStaticClassesArray", str + " " + (System.currentTimeMillis() - currentTimeMillis));
                }
                return true;
            } catch (Throwable th) {
                BdLog.e(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
