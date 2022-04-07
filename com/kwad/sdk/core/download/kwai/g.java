package com.kwad.sdk.core.download.kwai;

import android.app.Activity;
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
/* loaded from: classes5.dex */
public class g extends com.kwad.sdk.widget.a {
    public b a;
    public String b;
    public String c;
    public int d;
    public String e;
    public int f;

    /* loaded from: classes5.dex */
    public static class a {
        public Context a;
        public b b;
        public String c;
        public String d;
        public int e;
        public String f;
        public int g;

        public a(@NonNull Context context) {
            this.a = context;
        }

        public a a(b bVar) {
            this.b = bVar;
            return this;
        }

        public a a(@NonNull String str) {
            this.c = str;
            return this;
        }

        public com.kwad.sdk.widget.a a() {
            return new g(this);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public g(a aVar) {
        super(aVar.a);
        a(aVar);
    }

    private View a() {
        View inflate = LayoutInflater.from(Wrapper.wrapContextIfNeed(getContext())).inflate(R.layout.obfuscated_res_0x7f0d044f, (ViewGroup) null, false);
        inflate.findViewById(R.id.obfuscated_res_0x7f0910b4).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.a != null) {
                    g.this.a.c(g.this);
                }
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910b6);
        if (!TextUtils.isEmpty(this.c)) {
            textView.setText(this.c);
        }
        textView.setTextColor(this.d);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.a != null) {
                    g.this.a.a(g.this);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910b5);
        if (!TextUtils.isEmpty(this.e)) {
            textView2.setText(this.e);
        }
        textView2.setTextColor(this.f);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (g.this.a != null) {
                    g.this.a.b(g.this);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910b3)).setText(this.b);
        return inflate;
    }

    private void a(a aVar) {
        if (aVar.a instanceof Activity) {
            setOwnerActivity((Activity) aVar.a);
        }
        this.a = aVar.b;
        this.b = aVar.c;
        this.c = !TextUtils.isEmpty(aVar.d) ? aVar.d : aVar.a.getString(R.string.obfuscated_res_0x7f0f099e);
        this.d = aVar.e != 0 ? aVar.e : aVar.a.getResources().getColor(R.color.obfuscated_res_0x7f060754);
        this.e = !TextUtils.isEmpty(aVar.f) ? aVar.f : aVar.a.getString(R.string.obfuscated_res_0x7f0f099d);
        this.f = aVar.g != 0 ? aVar.g : aVar.a.getResources().getColor(R.color.obfuscated_res_0x7f060753);
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
