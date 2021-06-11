package d.a.n0.v1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f66005a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66006b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f66007c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f66008d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f66009e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66010f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f66011g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f66012h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f66009e != null) {
                ((WindowManager) c.this.f66006b.getSystemService("window")).removeViewImmediate(c.this.f66009e);
                c.this.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.k(cVar.f66006b.getString(R.string.data_init));
        }
    }

    /* renamed from: d.a.n0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1744c {
        c getSplash();
    }

    /* loaded from: classes4.dex */
    public class d extends TextView {

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f66015e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f66016f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f66017g;

        /* renamed from: h  reason: collision with root package name */
        public int f66018h;

        /* renamed from: i  reason: collision with root package name */
        public int f66019i;
        public boolean j;

        public d(c cVar, Context context) {
            super(context);
            this.f66018h = 0;
            this.f66019i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.j || this.f66016f == null) {
                return;
            }
            int i2 = this.f66019i;
            int i3 = this.f66018h;
            int i4 = i2 + (i3 / 10);
            this.f66019i = i4;
            if (i4 > i3 * 2) {
                this.f66019i = -i3;
            }
            this.f66016f.setTranslate(this.f66019i, 0.0f);
            this.f66015e.setLocalMatrix(this.f66016f);
            postInvalidateDelayed(50L);
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (this.f66018h == 0) {
                int measuredWidth = getMeasuredWidth();
                this.f66018h = measuredWidth;
                if (measuredWidth > 0) {
                    this.f66017g = getPaint();
                    LinearGradient linearGradient = new LinearGradient(-this.f66018h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.f66015e = linearGradient;
                    this.f66017g.setShader(linearGradient);
                    this.f66016f = new Matrix();
                }
            }
        }
    }

    public c(Context context) {
        this.f66006b = context;
    }

    public final void e() {
        Handler handler = this.f66008d;
        if (handler != null) {
            handler.removeCallbacks(this.f66011g);
            this.f66008d.removeCallbacks(this.f66012h);
            this.f66012h = null;
            this.f66011g = null;
            this.f66008d = null;
        }
        HandlerThread handlerThread = this.f66007c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.f66010f != null) {
            this.f66010f = null;
        }
        if (this.f66009e != null) {
            this.f66009e = null;
        }
        this.f66005a = false;
    }

    public final List<String> f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("com.baidu.tieba.SPLASH_PIPELINE_ACTION");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        ArrayList arrayList = new ArrayList();
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.name;
                arrayList.add(StringUtil.ARRAY_START + packageName + "/" + str + "}");
            }
        }
        return arrayList;
    }

    public void g() {
        if (this.f66009e == null || this.f66010f == null) {
            return;
        }
        this.f66008d.removeCallbacks(this.f66011g);
        this.f66008d.post(this.f66011g);
    }

    public final boolean h() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.f66006b.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.f66006b.getPackageName();
        int myPid = Process.myPid();
        for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
            if (runningAppProcesses.get(i2).pid == myPid && TextUtils.equals(runningAppProcesses.get(i2).processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i() {
        List<String> f2 = f(this.f66006b);
        if (f2 != null && f2.size() != 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f66006b.getSystemService("activity")).getRunningTasks(1).get(0);
            String shortString = runningTaskInfo.baseActivity.toShortString();
            String shortString2 = runningTaskInfo.topActivity.toShortString();
            for (String str : f2) {
                if (shortString.equals(str) || shortString2.equals(str)) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
        }
        return false;
    }

    public void j() {
        if (!this.f66005a && h() && i()) {
            if (this.f66007c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f66007c = handlerThread;
                handlerThread.start();
            }
            if (this.f66008d == null) {
                this.f66008d = new Handler(this.f66007c.getLooper());
            }
            if (this.f66011g == null) {
                this.f66011g = new a();
            }
            if (this.f66012h == null) {
                this.f66012h = new b();
            }
            this.f66008d.removeCallbacks(this.f66012h);
            this.f66008d.postAtFrontOfQueue(this.f66012h);
            this.f66005a = true;
            this.f66008d.postDelayed(this.f66011g, 20000L);
        }
    }

    public final void k(String str) {
        if (this.f66010f == null) {
            d dVar = new d(this, this.f66006b);
            this.f66010f = dVar;
            dVar.setTextSize(1, 18.0f);
        }
        this.f66010f.setText(str);
        RelativeLayout relativeLayout = new RelativeLayout(this.f66006b);
        this.f66009e = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f66009e.addView(this.f66010f, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.f66006b.getSystemService("window")).addView(this.f66009e, layoutParams2);
    }
}
