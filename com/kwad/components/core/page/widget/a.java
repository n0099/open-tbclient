package com.kwad.components.core.page.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes9.dex */
public final class a extends Dialog {
    public final InterfaceC0640a GY;
    public final String GZ;

    /* renamed from: com.kwad.components.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0640a {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public a(@NonNull Context context, @NonNull InterfaceC0640a interfaceC0640a) {
        this(context, null, interfaceC0640a);
    }

    public a(@NonNull Context context, String str, @NonNull InterfaceC0640a interfaceC0640a) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        this.GY = interfaceC0640a;
        this.GZ = str;
    }

    private View nZ() {
        View inflate = LayoutInflater.from(Wrapper.wrapContextIfNeed(getContext())).inflate(R.layout.obfuscated_res_0x7f0d04ed, (ViewGroup) null, false);
        inflate.findViewById(R.id.obfuscated_res_0x7f091285).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.GY.c(a.this);
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091284).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091414).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.GY.a(a.this);
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091413).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.GY.b(a.this);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091283);
        if (!TextUtils.isEmpty(this.GZ)) {
            textView.setText(this.GZ);
        }
        return inflate;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(nZ());
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        setCancelable(false);
    }
}
