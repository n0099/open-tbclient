package d.b.h0.r.p;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import d.b.b.e.m.e;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f50690b;

    /* renamed from: a  reason: collision with root package name */
    public Runnable f50691a = new RunnableC1086a();

    /* renamed from: d.b.h0.r.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1086a implements Runnable {
        public RunnableC1086a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(0);
        }
    }

    public static a c() {
        if (f50690b == null) {
            synchronized (a.class) {
                if (f50690b == null) {
                    f50690b = new a();
                }
            }
        }
        return f50690b;
    }

    public boolean a() {
        return RomTypeUtil.check("EMUI");
    }

    public void b() {
        if (a() || DeviceInfoUtil.isHonor()) {
            d(1);
            e.a().postDelayed(this.f50691a, 500L);
        }
    }

    public void d(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("package", "com.baidu.tieba");
            bundle.putString(DealIntentService.KEY_CLASS, "com.baidu.tieba.LogoActivity");
            bundle.putInt("badgenumber", i);
            TbadkApplication.getInst().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Throwable th) {
            Log.i("huawei_corner", th.getMessage());
        }
    }
}
