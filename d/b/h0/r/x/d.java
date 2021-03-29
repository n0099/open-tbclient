package d.b.h0.r.x;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStaticClassesArray;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f51070a = {"com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", "com.baidu.tieba.advert.sdk.AdvertSDKStatic", "com.baidu.tieba.funad.FunAdStatic", "com.baidu.tieba.recapp.lego.RecAppLegoStatic", "com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic", "com.baidu.tbadk.core.LaunchStatic", "com.baidu.tieba.emotion.BasePlugInFaceProviderStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.im.TiebaIMActivityStatic", "com.baidu.tbadk.plugins.Static", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic", "com.baidu.tieba.personCenter.PersonInfoDelegateStatic", "com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic", "com.baidu.tieba.location.LocationProvidersStatic", "com.baidu.tieba.ala.livecard.Static", "com.baidu.tieba.emotion.PlugInFaceProviderStatic", "com.baidu.tieba.flutter.FlutterStatic"};

    /* renamed from: b  reason: collision with root package name */
    public static boolean f51071b;

    public static void a() {
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
                Log.e("staticClassesArray: ", "fail");
                e2.printStackTrace();
            }
            Log.e("staticClassesArray: ", "" + tiebaStaticClassesArray.staticClassesArray.length);
            if (d.b.h0.r.d0.b.i().j("static_opt_open", 0) <= 0) {
                z = false;
            }
            f51071b = z;
            long currentTimeMillis = System.currentTimeMillis();
            if (f51071b) {
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

    public static boolean b() {
        String[] strArr;
        try {
            if (f51070a.length <= 0) {
                return false;
            }
            for (String str : f51070a) {
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
}
