package d.a.m0.f.j.m;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import d.a.m0.f.j.h;
import d.a.m0.f.j.i;
import d.a.m0.f.j.l;
/* loaded from: classes3.dex */
public class f extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnClickListener f50659e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.dismiss();
            f fVar = f.this;
            DialogInterface.OnClickListener onClickListener = fVar.f50659e;
            if (onClickListener != null) {
                onClickListener.onClick(fVar, -2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.dismiss();
            f fVar = f.this;
            DialogInterface.OnClickListener onClickListener = fVar.f50659e;
            if (onClickListener != null) {
                onClickListener.onClick(fVar, -1);
            }
        }
    }

    public f(@NonNull Context context) {
        super(context, l.AiappsGameGuideDialogStyle);
        this.f50659e = null;
    }

    public final void a() {
        TextView textView = (TextView) findViewById(h.tv_cancel);
        TextView textView2 = (TextView) findViewById(h.tv_ensure);
        d.a.m0.h.o0.g.f.e.a(textView);
        d.a.m0.h.o0.g.f.e.a(textView2);
        textView.setOnClickListener(new a());
        textView2.setOnClickListener(new b());
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.aiapps_game_guide_not_show_ensure_dialog);
        setCancelable(false);
        a();
    }
}
