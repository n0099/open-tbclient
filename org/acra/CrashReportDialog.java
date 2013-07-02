package org.acra;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class CrashReportDialog extends Activity {
    String a;
    private SharedPreferences b;
    private EditText c;
    private EditText d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        this.a = getIntent().getStringExtra("REPORT_FILE_NAME");
        Log.d(a.a, "Opening CrashReportDialog for " + this.a);
        if (this.a == null) {
            finish();
        }
        requestWindowFeature(3);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(10, 10, 10, 10);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        ScrollView scrollView = new ScrollView(this);
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        scrollView.addView(linearLayout2);
        TextView textView = new TextView(this);
        textView.setText(getText(a.d().v()));
        linearLayout2.addView(textView);
        int r = a.d().r();
        if (r != 0) {
            TextView textView2 = new TextView(this);
            textView2.setText(getText(r));
            textView2.setPadding(textView2.getPaddingLeft(), 10, textView2.getPaddingRight(), textView2.getPaddingBottom());
            linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
            this.c = new EditText(this);
            this.c.setLines(2);
            if (bundle != null && (string = bundle.getString("comment")) != null) {
                this.c.setText(string);
            }
            linearLayout2.addView(this.c);
        }
        int s = a.d().s();
        if (s != 0) {
            TextView textView3 = new TextView(this);
            textView3.setText(getText(s));
            textView3.setPadding(textView3.getPaddingLeft(), 10, textView3.getPaddingRight(), textView3.getPaddingBottom());
            linearLayout2.addView(textView3);
            this.d = new EditText(this);
            this.d.setSingleLine();
            this.d.setInputType(33);
            this.b = getSharedPreferences(a.d().D(), a.d().C());
            String str = null;
            if (bundle != null) {
                str = bundle.getString("email");
            }
            if (str != null) {
                this.d.setText(str);
            } else {
                this.d.setText(this.b.getString("acra.user.email", ""));
            }
            linearLayout2.addView(this.d);
        }
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.setPadding(linearLayout3.getPaddingLeft(), 10, linearLayout3.getPaddingRight(), linearLayout3.getPaddingBottom());
        Button button = new Button(this);
        button.setText(17039379);
        button.setOnClickListener(new f(this));
        linearLayout3.addView(button, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        Button button2 = new Button(this);
        button2.setText(17039369);
        button2.setOnClickListener(new g(this));
        linearLayout3.addView(button2, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        setContentView(linearLayout);
        int w = a.d().w();
        if (w != 0) {
            setTitle(w);
        }
        getWindow().setFeatureDrawableResource(3, a.d().t());
        a();
        scrollView.post(new h(this, scrollView));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.c != null && this.c.getText() != null) {
            bundle.putString("comment", this.c.getText().toString());
        }
        if (this.d != null && this.d.getText() != null) {
            bundle.putString("email", this.d.getText().toString());
        }
    }

    protected void a() {
        ((NotificationManager) getSystemService("notification")).cancel(666);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.a().b(false);
        }
        return super.onKeyUp(i, keyEvent);
    }
}
