package com.kwad.sdk.reward;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.RewardTaskStepView;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KSCornerImageView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends com.kwad.sdk.h.e {
    public static j a = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f57282d = "奖励还差 %s 步到手，\n确认放弃吗？";

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57283b;

    /* renamed from: c  reason: collision with root package name */
    public b f57284c;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f57295b;

        /* renamed from: c  reason: collision with root package name */
        public String f57296c;

        /* renamed from: d  reason: collision with root package name */
        public String f57297d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.reward.b.a.a f57298e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.reward.b.kwai.a f57299f;

        /* renamed from: g  reason: collision with root package name */
        public String f57300g;

        public static a a(AdInfo adInfo) {
            a aVar = new a();
            aVar.a = 3;
            aVar.f57295b = com.kwad.sdk.core.response.a.a.aD(adInfo);
            aVar.f57300g = com.kwad.sdk.core.response.a.a.aE(adInfo);
            return aVar;
        }

        public static a a(com.kwad.sdk.reward.b.a.a aVar, AdTemplate adTemplate) {
            a aVar2 = new a();
            aVar2.a = 1;
            aVar2.f57298e = aVar;
            aVar2.f57300g = com.kwad.sdk.core.response.a.a.au(com.kwad.sdk.core.response.a.d.j(adTemplate));
            return aVar2;
        }

        public static a a(com.kwad.sdk.reward.b.kwai.a aVar, AdTemplate adTemplate) {
            a aVar2 = new a();
            aVar2.a = 2;
            aVar2.f57299f = aVar;
            aVar2.f57300g = com.kwad.sdk.core.response.a.a.au(com.kwad.sdk.core.response.a.d.j(adTemplate));
            return aVar2;
        }

        public static a a(String str) {
            a aVar = new a();
            aVar.a = 0;
            aVar.f57295b = str;
            aVar.f57296c = "关闭广告";
            aVar.f57297d = "继续观看";
            return aVar;
        }

        public static a b(AdInfo adInfo) {
            a aVar = new a();
            aVar.a = 4;
            AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(adInfo);
            aVar.f57295b = com.kwad.sdk.core.response.a.a.s(adInfo);
            aVar.f57300g = aK.getIcon();
            return aVar;
        }

        public static a b(String str) {
            a aVar = new a();
            aVar.a = 0;
            aVar.f57295b = str;
            aVar.f57296c = "奖励不要了";
            aVar.f57297d = "返回";
            return aVar;
        }

        public static a c(String str) {
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return aVar;
        }

        public int a() {
            return this.a;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.f57298e == null) {
                    this.f57298e = new com.kwad.sdk.reward.b.a.a();
                }
                this.f57298e.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.f57299f == null) {
                    this.f57299f = new com.kwad.sdk.reward.b.kwai.a();
                }
                this.f57299f.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.sdk.reward.b.a.a aVar = this.f57298e;
            if (aVar != null) {
                t.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.sdk.reward.b.kwai.a aVar2 = this.f57299f;
            if (aVar2 != null) {
                t.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public String b() {
            return this.f57295b;
        }

        public String c() {
            return TextUtils.isEmpty(this.f57296c) ? "关闭广告" : this.f57296c;
        }

        public String d() {
            return TextUtils.isEmpty(this.f57297d) ? "继续观看" : this.f57297d;
        }

        public com.kwad.sdk.reward.b.a.a e() {
            return this.f57298e;
        }

        public com.kwad.sdk.reward.b.kwai.a f() {
            return this.f57299f;
        }

        public String g() {
            return this.f57300g;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* loaded from: classes3.dex */
    public static class c implements b {
        @Override // com.kwad.sdk.reward.j.b
        public void a() {
        }

        @Override // com.kwad.sdk.reward.j.b
        public void b() {
        }

        @Override // com.kwad.sdk.reward.j.b
        public void c() {
        }

        @Override // com.kwad.sdk.reward.j.b
        public void d() {
        }

        @Override // com.kwad.sdk.reward.j.b
        public void e() {
        }
    }

    public static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, AdTemplate adTemplate, final b bVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        com.kwad.sdk.reward.b.a.a e2 = aVar.e();
        com.kwad.sdk.reward.b.a.a.a(e2, inflate.getContext(), adTemplate);
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(e2.m());
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), aVar.g(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        String str = e2.l() + "";
        String format = String.format(f57282d, str);
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, indexOf + 1, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        });
        return inflate;
    }

    public static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, final b bVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(aVar.b());
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(aVar.c());
        textView2.setText(aVar.d());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        });
        return inflate;
    }

    public static a a(AdTemplate adTemplate, @Nullable String str, @Nullable com.kwad.sdk.reward.b.a.a aVar, @Nullable com.kwad.sdk.reward.b.kwai.a aVar2) {
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        return (!com.kwad.sdk.core.response.a.d.u(adTemplate) || aVar == null) ? (!com.kwad.sdk.core.response.a.d.v(adTemplate) || aVar2 == null) ? (!com.kwad.sdk.core.response.a.a.aH(j2) || com.kwad.sdk.core.response.a.a.aA(j2)) ? com.kwad.sdk.core.response.a.a.aI(j2) ? a.b(j2) : com.kwad.sdk.core.response.a.a.as(j2) ? a.b(str) : a.a(str) : a.a(j2) : a.a(aVar2, adTemplate) : a.a(aVar, adTemplate);
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, b bVar) {
        a = new j();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", aVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        a.setArguments(bundle);
        a.a(bVar);
        a.show(activity.getFragmentManager(), "videoCloseDialog");
    }

    private void a(b bVar) {
        this.f57284c = bVar;
    }

    public static boolean a() {
        j jVar = a;
        return jVar != null && jVar.b();
    }

    public static View b(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, AdTemplate adTemplate, final b bVar) {
        com.kwad.sdk.reward.b.kwai.a f2;
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.f().j());
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), aVar.g(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        String str = f2.i() + "";
        String format = String.format(f57282d, str);
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, indexOf + 1, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        });
        return inflate;
    }

    public static View b(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, final b bVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_follow_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_reward_follow_dialog_title)).setText(aVar.b());
        inflate.findViewById(R.id.ksad_reward_follow_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_follow_dialog_btn_follow).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.d();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_follow_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        });
        KSImageLoader.loadCircleIcon((ImageView) inflate.findViewById(R.id.ksad_reward_follow_dialog_icon), aVar.g(), inflate.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
        return inflate;
    }

    public static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, a aVar, AdTemplate adTemplate, final b bVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), aVar.f57300g, adTemplate);
        ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(aVar.b());
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.e();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.j.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialogFragment.dismiss();
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        });
        return inflate;
    }

    @Override // com.kwad.sdk.h.e
    @Nullable
    public View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View a2;
        com.kwad.sdk.widget.c cVar;
        getDialog().requestWindowFeature(1);
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.f57283b = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        a c2 = a.c(string);
        int a3 = c2.a();
        if (a3 == 1) {
            a2 = a(this, layoutInflater, viewGroup, c2, this.f57283b, this.f57284c);
        } else if (a3 != 2) {
            if (a3 == 3) {
                a2 = b(this, layoutInflater, viewGroup, c2, this.f57284c);
                cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
            } else if (a3 != 4) {
                a2 = a(this, layoutInflater, viewGroup, c2, this.f57284c);
            } else {
                a2 = c(this, layoutInflater, viewGroup, c2, this.f57283b, this.f57284c);
                cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
            }
            w.a(cVar, (ViewGroup) a2);
        } else {
            a2 = b(this, layoutInflater, viewGroup, c2, this.f57283b, this.f57284c);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.sdk.reward.j.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4 && keyEvent.getAction() == 0;
            }
        });
        return a2;
    }

    public boolean b() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        b bVar = this.f57284c;
        if (bVar != null) {
            bVar.a();
        }
    }
}
