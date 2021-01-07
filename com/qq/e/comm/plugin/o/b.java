package com.qq.e.comm.plugin.o;

import android.content.Intent;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.y.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class b implements HADI {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f12633a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Integer, WeakReference<HybridADListener>> f12634b = new HashMap<>();
    private final HybridADListener c;
    private final HybridADSetting d;
    private final int e = f12633a.incrementAndGet();

    public b(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.d = hybridADSetting;
        this.c = hybridADListener;
        f12634b.put(Integer.valueOf(this.e), new WeakReference<>(hybridADListener));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HybridADListener a(int i) {
        WeakReference<HybridADListener> weakReference = f12634b.get(Integer.valueOf(i));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        ai.a("gdt_tag_callback", "loadUrl(url)");
        Intent intent = new Intent();
        intent.setClassName(GDTADManager.getInstance().getAppContext(), ar.a());
        intent.addFlags(268435456);
        intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, "hybridADPage");
        intent.putExtra("id", this.e);
        intent.putExtra("setting", this.d == null ? new HybridADSetting() : this.d);
        intent.putExtra("url", str);
        GDTADManager.getInstance().getAppContext().startActivity(intent);
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.o.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.c != null) {
                    b.this.c.onPageShow();
                }
            }
        });
        u.a(21042, 1, null);
    }
}
