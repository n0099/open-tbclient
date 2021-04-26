package d.a.j0.u1;

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
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f61409a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61410b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f61411c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f61412d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f61413e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61414f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f61415g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f61416h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f61413e != null) {
                ((WindowManager) c.this.f61410b.getSystemService("window")).removeViewImmediate(c.this.f61413e);
                c.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.k(cVar.f61410b.getString(R.string.data_init));
        }
    }

    /* renamed from: d.a.j0.u1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1609c {
        c getSplash();
    }

    /* loaded from: classes3.dex */
    public class d extends TextView {

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f61419e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f61420f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f61421g;

        /* renamed from: h  reason: collision with root package name */
        public int f61422h;

        /* renamed from: i  reason: collision with root package name */
        public int f61423i;
        public boolean j;

        public d(c cVar, Context context) {
            super(context);
            this.f61422h = 0;
            this.f61423i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.j || this.f61420f == null) {
                return;
            }
            int i2 = this.f61423i;
            int i3 = this.f61422h;
            int i4 = i2 + (i3 / 10);
            this.f61423i = i4;
            if (i4 > i3 * 2) {
                this.f61423i = -i3;
            }
            this.f61420f.setTranslate(this.f61423i, 0.0f);
            this.f61419e.setLocalMatrix(this.f61420f);
            postInvalidateDelayed(50L);
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (this.f61422h == 0) {
                int measuredWidth = getMeasuredWidth();
                this.f61422h = measuredWidth;
                if (measuredWidth > 0) {
                    this.f61421g = getPaint();
                    LinearGradient linearGradient = new LinearGradient(-this.f61422h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.f61419e = linearGradient;
                    this.f61421g.setShader(linearGradient);
                    this.f61420f = new Matrix();
                }
            }
        }
    }

    public c(Context context) {
        this.f61410b = context;
    }

    public final void e() {
        Handler handler = this.f61412d;
        if (handler != null) {
            handler.removeCallbacks(this.f61415g);
            this.f61412d.removeCallbacks(this.f61416h);
            this.f61416h = null;
            this.f61415g = null;
            this.f61412d = null;
        }
        HandlerThread handlerThread = this.f61411c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.f61414f != null) {
            this.f61414f = null;
        }
        if (this.f61413e != null) {
            this.f61413e = null;
        }
        this.f61409a = false;
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
        if (this.f61413e == null || this.f61414f == null) {
            return;
        }
        this.f61412d.removeCallbacks(this.f61415g);
        this.f61412d.post(this.f61415g);
    }

    public final boolean h() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.f61410b.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.f61410b.getPackageName();
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
        List<String> f2 = f(this.f61410b);
        if (f2 != null && f2.size() != 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f61410b.getSystemService("activity")).getRunningTasks(1).get(0);
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
        if (!this.f61409a && h() && i()) {
            if (this.f61411c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f61411c = handlerThread;
                handlerThread.start();
            }
            if (this.f61412d == null) {
                this.f61412d = new Handler(this.f61411c.getLooper());
            }
            if (this.f61415g == null) {
                this.f61415g = new a();
            }
            if (this.f61416h == null) {
                this.f61416h = new b();
            }
            this.f61412d.removeCallbacks(this.f61416h);
            this.f61412d.postAtFrontOfQueue(this.f61416h);
            this.f61409a = true;
            this.f61412d.postDelayed(this.f61415g, 20000L);
        }
    }

    public final void k(String str) {
        if (this.f61414f == null) {
            d dVar = new d(this, this.f61410b);
            this.f61414f = dVar;
            dVar.setTextSize(1, 18.0f);
        }
        this.f61414f.setText(str);
        RelativeLayout relativeLayout = new RelativeLayout(this.f61410b);
        this.f61413e = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f61413e.addView(this.f61414f, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.f61410b.getSystemService("window")).addView(this.f61413e, layoutParams2);
    }
}
