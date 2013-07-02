package com.mofamulu.tieba.dslv.lock;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.mofamulu.tieba.ch.bg;
import com.mofamulu.tieba.dslv.lock.LockPatternView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LockPatternActivity extends Activity {
    private static /* synthetic */ int[] F;
    private List B;
    private SharedPreferences o;
    private int p;
    private boolean q;
    private b r;
    private int s;
    private ButtonOkCommand t;
    private Intent u;
    private TextView v;
    private LockPatternView w;
    private View x;
    private Button y;
    private Button z;
    private static final String n = LockPatternActivity.class.getName();
    public static final String a = String.valueOf(n) + ".create_pattern";
    public static final String b = String.valueOf(n) + ".compare_pattern";
    public static final String c = String.valueOf(n) + ".retry_count";
    public static final String d = String.valueOf(n) + ".theme";
    public static final String e = String.valueOf(n) + ".auto_save";
    public static final String f = String.valueOf(n) + ".min_wired_dots";
    public static final String g = String.valueOf(n) + ".max_retry";
    public static final String h = String.valueOf(n) + ".pattern";
    public static final String i = b.class.getName();
    public static final String j = String.valueOf(n) + ".result_receiver";
    public static final String k = String.valueOf(n) + ".stealth_mode";
    public static final String l = String.valueOf(n) + ".ok_pending_intent";
    public static final String m = String.valueOf(n) + ".cancelled_pending_intent";
    private int A = 0;
    private final j C = new e(this);
    private final View.OnClickListener D = new f(this);
    private final View.OnClickListener E = new g(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum ButtonOkCommand {
        Continue,
        Done;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ButtonOkCommand[] valuesCustom() {
            ButtonOkCommand[] valuesCustom = values();
            int length = valuesCustom.length;
            ButtonOkCommand[] buttonOkCommandArr = new ButtonOkCommand[length];
            System.arraycopy(valuesCustom, 0, buttonOkCommandArr, 0, length);
            return buttonOkCommandArr;
        }
    }

    static /* synthetic */ int[] a() {
        int[] iArr = F;
        if (iArr == null) {
            iArr = new int[ButtonOkCommand.valuesCustom().length];
            try {
                iArr[ButtonOkCommand.Continue.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ButtonOkCommand.Done.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            F = iArr;
        }
        return iArr;
    }

    private static int b() {
        return TiebaApplication.f().as() == 1 ? 2131361839 : 2131361842;
    }

    public static Intent a(final Activity activity, bg bgVar) {
        Intent intent = new Intent(b, null, activity, LockPatternActivity.class);
        intent.putExtra(d, b());
        intent.putExtra(k, false);
        intent.putExtra(i, c.class);
        intent.putExtra(h, bgVar.O());
        intent.putExtra(g, 5);
        intent.putExtra(j, new ResultReceiver(new Handler()) { // from class: com.mofamulu.tieba.dslv.lock.LockPatternActivity.4
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i2, Bundle bundle) {
                switch (i2) {
                    case -1:
                        a.b = false;
                        a.c = System.currentTimeMillis();
                        return;
                    default:
                        Intent intent2 = new Intent(activity, UnLockFailedActivity.class);
                        intent2.putExtra(LockPatternActivity.c, bundle.getInt(LockPatternActivity.c));
                        activity.startActivity(intent2);
                        return;
                }
            }
        });
        return intent;
    }

    public static Intent b(Activity activity, final bg bgVar) {
        Intent intent = new Intent(a, null, activity, LockPatternActivity.class);
        intent.putExtra(d, b());
        intent.putExtra(k, false);
        intent.putExtra(i, c.class);
        intent.putExtra(f, 4);
        intent.putExtra(j, new ResultReceiver(new Handler()) { // from class: com.mofamulu.tieba.dslv.lock.LockPatternActivity.5
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i2, Bundle bundle) {
                switch (i2) {
                    case -1:
                        bgVar.e(bundle.getString(LockPatternActivity.h));
                        a.c = System.currentTimeMillis();
                        return;
                    default:
                        return;
                }
            }
        });
        return intent;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent().hasExtra(d)) {
            setTheme(getIntent().getIntExtra(d, 2131361839));
        }
        super.onCreate(bundle);
        this.o = getSharedPreferences(LockPatternActivity.class.getName(), 0);
        if (!a.equals(getIntent().getAction()) && !b.equals(getIntent().getAction())) {
            throw new UnsupportedOperationException("Unknown Action >> " + getIntent().getAction());
        }
        this.s = getIntent().getIntExtra(f, 4);
        if (this.s <= 0 || this.s > 9) {
            this.s = 4;
        }
        this.p = getIntent().getIntExtra(g, 5);
        this.q = getIntent().getBooleanExtra(e, false);
        if (!this.q) {
            this.o.edit().clear().commit();
        }
        Class cls = (Class) getIntent().getSerializableExtra(i);
        if (cls != null) {
            try {
                this.r = (b) cls.newInstance();
            } catch (Throwable th) {
                throw new InvalidEncrypterException();
            }
        }
        this.u = new Intent();
        setResult(0, this.u);
        c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Log.d(n, "onConfigurationChanged()");
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && b.equals(getIntent().getAction())) {
            a(0);
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    private void c() {
        boolean z;
        CharSequence text = this.v != null ? this.v.getText() : null;
        Boolean valueOf = this.z != null ? Boolean.valueOf(this.z.isEnabled()) : null;
        LockPatternView.DisplayMode displayMode = this.w != null ? this.w.getDisplayMode() : null;
        List pattern = this.w != null ? this.w.getPattern() : null;
        setContentView(R.layout.alp_lock_pattern_activity);
        l.a(getWindow());
        this.v = (TextView) findViewById(R.id.alp_info);
        this.w = (LockPatternView) findViewById(R.id.alp_lock_pattern);
        this.x = findViewById(R.id.alp_footer);
        this.y = (Button) findViewById(R.id.alp_cancel);
        this.z = (Button) findViewById(R.id.alp_confirm);
        if (getResources().getBoolean(R.bool.alp_is_large_screen) && !getWindow().isFloating()) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.alp_lockpatternview_size);
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.w.setLayoutParams(layoutParams);
        }
        try {
            z = Settings.System.getInt(getContentResolver(), "haptic_feedback_enabled", 0) != 0;
        } catch (Throwable th) {
            z = false;
        }
        this.w.setTactileFeedbackEnabled(z);
        this.w.setInStealthMode(getIntent().getBooleanExtra(k, false));
        this.w.setOnPatternListener(this.C);
        if (pattern != null && displayMode != null) {
            this.w.a(displayMode, pattern);
        }
        if (a.equals(getIntent().getAction())) {
            this.y.setOnClickListener(this.D);
            this.z.setOnClickListener(this.E);
            this.x.setVisibility(0);
            if (text != null) {
                this.v.setText(text);
            } else {
                this.v.setText(R.string.alp_msg_draw_an_unlock_pattern);
            }
            if (this.t == null) {
                this.t = ButtonOkCommand.Continue;
            }
            switch (a()[this.t.ordinal()]) {
                case 1:
                    this.z.setText(R.string.alp_cmd_continue);
                    break;
                case 2:
                    this.z.setText(R.string.alp_cmd_confirm);
                    break;
            }
            if (valueOf != null) {
                this.z.setEnabled(valueOf.booleanValue());
            }
        } else if (b.equals(getIntent().getAction())) {
            this.x.setVisibility(8);
            if (text != null) {
                this.v.setText(text);
            } else {
                this.v.setText(R.string.alp_msg_draw_pattern_to_unlock);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(List list) {
        if (this.r == null) {
            return h.b(list);
        }
        try {
            return this.r.a(this, h.b(list));
        } catch (Throwable th) {
            throw new InvalidEncrypterException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List list) {
        if (list != null) {
            this.B = new ArrayList();
            this.B.addAll(list);
            String stringExtra = getIntent().getStringExtra(h);
            if (stringExtra == null) {
                stringExtra = this.o.getString(h, null);
            }
            if (a(list).equals(stringExtra)) {
                a((String) null);
                return;
            }
            this.A++;
            this.u.putExtra(c, this.A);
            if (this.A >= this.p) {
                a(2);
                return;
            }
            this.w.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            this.v.setText(R.string.alp_msg_try_again);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List list) {
        if (list.size() < this.s) {
            this.w.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            this.v.setText(getString(R.string.alp_pmsg_connect_x_dots, new Object[]{Integer.valueOf(this.s)}));
        } else if (this.B == null) {
            this.B = new ArrayList();
            this.B.addAll(list);
            this.v.setText(R.string.alp_msg_pattern_recorded);
            this.z.setEnabled(true);
        } else if (a(this.B).equals(a(list))) {
            this.v.setText(R.string.alp_msg_your_new_unlock_pattern);
            this.z.setEnabled(true);
        } else {
            this.v.setText(R.string.alp_msg_redraw_pattern_to_confirm);
            this.z.setEnabled(false);
            this.w.setDisplayMode(LockPatternView.DisplayMode.Wrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (a.equals(getIntent().getAction())) {
            this.u.putExtra(h, str);
        } else {
            this.u.putExtra(c, this.A + 1);
        }
        setResult(-1, this.u);
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra(j);
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            if (a.equals(getIntent().getAction())) {
                bundle.putString(h, str);
            } else {
                bundle.putInt(c, this.A + 1);
            }
            resultReceiver.send(-1, bundle);
        }
        PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra(l);
        if (pendingIntent != null) {
            try {
                pendingIntent.send(this, -1, this.u);
            } catch (Throwable th) {
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (b.equals(getIntent().getAction())) {
            this.u.putExtra(c, this.A);
        }
        setResult(i2, this.u);
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra(j);
        if (resultReceiver != null) {
            Bundle bundle = null;
            if (b.equals(getIntent().getAction())) {
                bundle = new Bundle();
                bundle.putInt(c, this.A);
            }
            resultReceiver.send(i2, bundle);
        }
        PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra(m);
        if (pendingIntent != null) {
            try {
                pendingIntent.send(this, i2, this.u);
            } catch (Throwable th) {
            }
        }
        finish();
    }
}
