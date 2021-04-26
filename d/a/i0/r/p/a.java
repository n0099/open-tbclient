package d.a.i0.r.p;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import d.a.c.e.m.e;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f49054b;

    /* renamed from: a  reason: collision with root package name */
    public Runnable f49055a = new RunnableC1061a();

    /* renamed from: d.a.i0.r.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1061a implements Runnable {
        public RunnableC1061a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(0);
        }
    }

    public static a c() {
        if (f49054b == null) {
            synchronized (a.class) {
                if (f49054b == null) {
                    f49054b = new a();
                }
            }
        }
        return f49054b;
    }

    public boolean a() {
        return RomTypeUtil.check("EMUI");
    }

    public void b() {
        if (a() || DeviceInfoUtil.isHonor()) {
            d(1);
            e.a().postDelayed(this.f49055a, 500L);
        }
    }

    public void d(int i2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("package", "com.baidu.tieba");
            bundle.putString(DealIntentService.KEY_CLASS, "com.baidu.tieba.LogoActivity");
            bundle.putInt("badgenumber", i2);
            TbadkApplication.getInst().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Throwable th) {
            Log.i("huawei_corner", th.getMessage());
        }
    }
}
