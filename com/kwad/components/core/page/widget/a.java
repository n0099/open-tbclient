package com.kwad.components.core.page.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public final class a extends Dialog {
    public final InterfaceC0658a Qk;
    public final String Ql;

    /* renamed from: com.kwad.components.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0658a {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public a(@NonNull Context context, @NonNull InterfaceC0658a interfaceC0658a) {
        this(context, null, interfaceC0658a);
    }

    public a(@NonNull Context context, String str, @NonNull InterfaceC0658a interfaceC0658a) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        this.Qk = interfaceC0658a;
        this.Ql = str;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Exception unused) {
        }
        setContentView(pQ());
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        setCancelable(false);
    }

    private View pQ() {
        View inflate = l.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0532, null);
        inflate.findViewById(R.id.obfuscated_res_0x7f091365).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.Qk.c(a.this);
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091364).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f09151c).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.Qk.a(a.this);
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f09151b).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.Qk.b(a.this);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091363);
        if (!TextUtils.isEmpty(this.Ql)) {
            textView.setText(this.Ql);
        }
        return inflate;
    }
}
