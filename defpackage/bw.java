package defpackage;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.Build;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.zeus.Headers;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bw  reason: default package */
/* loaded from: classes.dex */
public class bw extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private static final String f389a = bw.class.getSimpleName();
    private static final ViewGroup.LayoutParams b = new ViewGroup.LayoutParams(-1, -1);
    private Context c;
    private String d;
    private String e;
    private IBaiduListener f;
    private ProgressDialog g;
    private WebView h;
    private LinearLayout i;
    private final SocialConfig j;

    public bw(Context context, String str, String str2, IBaiduListener iBaiduListener) {
        super(context, 16973837);
        this.c = getContext();
        this.d = str;
        this.e = str2;
        this.f = iBaiduListener;
        this.j = SocialConfig.getInstance(context);
    }

    private void a() {
        this.g = new ProgressDialog(this.c);
        this.g.requestWindowFeature(1);
        this.g.setMessage(this.j.getString("loading"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (str.startsWith("http://openapi.baidu.com/social/oauth/2.0/login_success")) {
            dismiss();
            JSONObject fragmentParams = Utils.getFragmentParams(str);
            if (this.e.equals(fragmentParams.optString(SocialConstants.PARAM_STATE))) {
                this.f.onComplete(fragmentParams);
                return true;
            }
            this.f.onError(new BaiduException("state parameter in response & request are not same, it may be a csrf attack"));
            return true;
        } else if (str.startsWith("http://openapi.baidu.com/social/oauth/2.0/error")) {
            dismiss();
            int optInt = Utils.getQueryParams(str).optInt(SocialConstants.PARAM_ERROR_CODE, -1);
            this.f.onError(new BaiduException(optInt, SocialAPIErrorCodes.getErrorDescription(optInt)));
            return true;
        } else {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!scheme.equals("http") && !scheme.equals("https")) {
                this.c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
            if (Build.DEBUG) {
                Log.d(f389a, "scheme: " + parse.toString());
            }
            return false;
        }
    }

    private void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        relativeLayout.setBackgroundDrawable(DrawableUtils.getDrawable(this.c, this.j.getAssetFileName("titlebar_bg")));
        this.i.addView(relativeLayout, new LinearLayout.LayoutParams(-1, DrawableUtils.fix720px(this.c, 88)));
        int fix720px = DrawableUtils.fix720px(this.c, 34);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DrawableUtils.fix720px(this.c, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED), DrawableUtils.fix720px(this.c, 65));
        layoutParams.leftMargin = fix720px;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        Button button = new Button(this.c);
        button.setText(this.j.getString("back"));
        button.setOnClickListener(new bz(this));
        Drawable drawable = DrawableUtils.getDrawable(this.c, this.j.getAssetFileName("titlebar_btn"));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, DrawableUtils.getDrawable(this.c, this.j.getAssetFileName("titlebar_btn_mask"))});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, layerDrawable);
        stateListDrawable.addState(new int[0], drawable);
        button.setBackgroundDrawable(stateListDrawable);
        relativeLayout.addView(button, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DrawableUtils.fix720px(this.c, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED), DrawableUtils.fix720px(this.c, 65));
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = fix720px;
        Button button2 = new Button(this.c);
        button2.setText(this.j.getString(Headers.REFRESH));
        button2.setOnClickListener(new ca(this));
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        stateListDrawable2.addState(new int[]{16842919}, layerDrawable);
        stateListDrawable2.addState(new int[0], drawable);
        button2.setBackgroundDrawable(stateListDrawable2);
        relativeLayout.addView(button2, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = DrawableUtils.fix720px(this.c, 20);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(14, -1);
        TextView textView = new TextView(this.c);
        textView.setText(this.j.getString("auth_dialog_title"));
        textView.setTextColor(-13487566);
        textView.setTextSize(0, DrawableUtils.fix720px(this.c, 38));
        textView.setShadowLayer(1.0f, 0.0f, 1.0f, -1);
        relativeLayout.addView(textView, layoutParams3);
    }

    private void c() {
        this.h = new WebView(this.c);
        this.h.setVerticalScrollBarEnabled(true);
        this.h.getSettings().setJavaScriptEnabled(true);
        this.h.setWebChromeClient(new bx(this, null));
        this.h.getSettings().setSavePassword(true);
        this.h.setWebViewClient(new by(this, null));
        this.h.loadUrl(this.d);
        this.h.requestFocus();
        this.h.setVisibility(4);
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setOrientation(1);
        linearLayout.addView(this.h, b);
        this.i.addView(linearLayout, b);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.g.isShowing()) {
            this.g.dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
        this.h.stopLoading();
        this.f.onCancel();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = new LinearLayout(this.c);
        this.i.setOrientation(1);
        a();
        b();
        c();
        addContentView(this.i, b);
    }
}
