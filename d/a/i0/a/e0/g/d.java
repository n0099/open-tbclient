package d.a.i0.a.e0.g;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.baidu.webkit.sdk.Log;
import java.text.DecimalFormat;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static ActivityManager f41328b = (ActivityManager) d.a.i0.a.c1.a.b().getSystemService("activity");

    /* renamed from: c  reason: collision with root package name */
    public static int f41329c;

    /* renamed from: d  reason: collision with root package name */
    public static int f41330d;

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f41331a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f41332a = new d();
    }

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_memory_sample", 0);
        f41329c = 0;
        f41330d = new Random().nextInt(100);
    }

    public static d b() {
        return b.f41332a;
    }

    public final String a(float f2) {
        return this.f41331a.format(f2);
    }

    public String c(int i2) {
        if (e()) {
            JSONObject jSONObject = new JSONObject();
            try {
                d.a.i0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo mainPid: " + i2);
                Debug.MemoryInfo[] processMemoryInfo = f41328b.getProcessMemoryInfo(new int[]{Process.myPid(), i2});
                if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                    Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                    if (memoryInfo != null) {
                        jSONObject.put("smart_app_used_mem", a(((float) Debug.getPss()) / 1024.0f));
                        jSONObject.put("total_rss", a((((memoryInfo.getTotalPrivateClean() + memoryInfo.getTotalPrivateDirty()) + memoryInfo.getTotalSharedClean()) + memoryInfo.getTotalSharedDirty()) / 1024.0f));
                        jSONObject.put("private_clean", a(memoryInfo.getTotalPrivateClean() / 1024.0f));
                        jSONObject.put("private_dirty", a(memoryInfo.getTotalPrivateDirty() / 1024.0f));
                        jSONObject.put("shared_clean", a(memoryInfo.getTotalSharedClean() / 1024.0f));
                        jSONObject.put("shared_dirty", a(memoryInfo.getTotalSharedDirty() / 1024.0f));
                    }
                    Debug.MemoryInfo memoryInfo2 = processMemoryInfo[1];
                    if (memoryInfo2 != null) {
                        jSONObject.put("host_used_mem", a((((memoryInfo2.getTotalPrivateClean() + memoryInfo2.getTotalPrivateDirty()) + memoryInfo2.getTotalSharedClean()) + memoryInfo2.getTotalSharedDirty()) / 1024.0f));
                    }
                }
                ActivityManager.MemoryInfo memoryInfo3 = new ActivityManager.MemoryInfo();
                f41328b.getMemoryInfo(memoryInfo3);
                jSONObject.put("sys_free_mem", a(((float) memoryInfo3.availMem) / 1048576.0f));
                jSONObject.put("sys_low_mem", memoryInfo3.lowMemory ? "1" : "0");
                jSONObject.put("native_heap", a(((float) Debug.getNativeHeapSize()) / 1048576.0f));
                jSONObject.put("native_heap_alloc", a(((float) Debug.getNativeHeapAllocatedSize()) / 1048576.0f));
                jSONObject.put("vm_max_mem", a(((float) Runtime.getRuntime().maxMemory()) / 1048576.0f));
                jSONObject.put("vm_total_mem", a(((float) Runtime.getRuntime().totalMemory()) / 1048576.0f));
                jSONObject.put("vm_free_mem", a(((float) Runtime.getRuntime().freeMemory()) / 1048576.0f));
                jSONObject.put("thread_count", Thread.activeCount());
            } catch (Exception e2) {
                d.a.i0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo: " + Log.getStackTraceString(e2));
            }
            d.a.i0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo result=" + jSONObject);
            return jSONObject.toString();
        }
        return "";
    }

    public String d() {
        if (e()) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f41328b.getMemoryInfo(memoryInfo);
            String a2 = a(((float) memoryInfo.totalMem) / 1048576.0f);
            d.a.i0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo sysTotalMemory=" + a2);
            return a2;
        }
        return "";
    }

    public final boolean e() {
        d.a.i0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo mMemSample =" + f41329c + "; mRandomNum =" + f41330d);
        int i2 = f41329c;
        if (i2 <= 0) {
            return false;
        }
        return i2 >= 100 || f41330d <= i2;
    }

    public d() {
        this.f41331a = new DecimalFormat("#.###");
    }
}
