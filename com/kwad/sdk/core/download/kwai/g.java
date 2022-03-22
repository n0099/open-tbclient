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
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.widget.a {
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public String f39501b;

    /* renamed from: c  reason: collision with root package name */
    public String f39502c;

    /* renamed from: d  reason: collision with root package name */
    public int f39503d;

    /* renamed from: e  reason: collision with root package name */
    public String f39504e;

    /* renamed from: f  reason: collision with root package name */
    public int f39505f;

    /* loaded from: classes7.dex */
    public static class a {
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public b f39506b;

        /* renamed from: c  reason: collision with root package name */
        public String f39507c;

        /* renamed from: d  reason: collision with root package name */
        public String f39508d;

        /* renamed from: e  reason: collision with root package name */
        public int f39509e;

        /* renamed from: f  reason: collision with root package name */
        public String f39510f;

        /* renamed from: g  reason: collision with root package name */
        public int f39511g;

        public a(@NonNull Context context) {
            this.a = context;
        }

        public a a(b bVar) {
            this.f39506b = bVar;
            return this;
        }

        public a a(@NonNull String str) {
            this.f39507c = str;
            return this;
        }

        public com.kwad.sdk.widget.a a() {
            return new g(this);
        }
    }

    /* loaded from: classes7.dex */
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
        View inflate = LayoutInflater.from(Wrapper.wrapContextIfNeed(getContext())).inflate(R.layout.obfuscated_res_0x7f0d0454, (ViewGroup) null, false);
        inflate.findViewById(R.id.obfuscated_res_0x7f0910bb).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.c(g.this);
                }
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910bd);
        if (!TextUtils.isEmpty(this.f39502c)) {
            textView.setText(this.f39502c);
        }
        textView.setTextColor(this.f39503d);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.a(g.this);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910bc);
        if (!TextUtils.isEmpty(this.f39504e)) {
            textView2.setText(this.f39504e);
        }
        textView2.setTextColor(this.f39505f);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.a != null) {
                    g.this.a.b(g.this);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910ba)).setText(this.f39501b);
        return inflate;
    }

    private void a(a aVar) {
        if (aVar.a instanceof Activity) {
            setOwnerActivity((Activity) aVar.a);
        }
        this.a = aVar.f39506b;
        this.f39501b = aVar.f39507c;
        this.f39502c = !TextUtils.isEmpty(aVar.f39508d) ? aVar.f39508d : aVar.a.getString(R.string.obfuscated_res_0x7f0f099e);
        this.f39503d = aVar.f39509e != 0 ? aVar.f39509e : aVar.a.getResources().getColor(R.color.obfuscated_res_0x7f06074b);
        this.f39504e = !TextUtils.isEmpty(aVar.f39510f) ? aVar.f39510f : aVar.a.getString(R.string.obfuscated_res_0x7f0f099d);
        this.f39505f = aVar.f39511g != 0 ? aVar.f39511g : aVar.a.getResources().getColor(R.color.obfuscated_res_0x7f06074a);
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
