package com.kwad.sdk.core.page.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes7.dex */
public class b extends Dialog {
    public a a;

    /* loaded from: classes7.dex */
    public interface a {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public b(@NonNull Context context, @NonNull a aVar) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        this.a = aVar;
    }

    private View a() {
        View inflate = LayoutInflater.from(Wrapper.wrapContextIfNeed(getContext())).inflate(R.layout.obfuscated_res_0x7f0d0488, (ViewGroup) null, false);
        inflate.findViewById(R.id.obfuscated_res_0x7f091083).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.widget.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a.c(b.this);
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091082).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.widget.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091190).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.widget.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a.a(b.this);
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f09118f).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.widget.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a.b(b.this);
            }
        });
        return inflate;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(a());
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }
}
