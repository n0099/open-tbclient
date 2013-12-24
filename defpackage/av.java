package defpackage;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.ui.ListStyleShareMenu;
import com.baidu.cloudsdk.social.share.ui.WeixinShareMenu;
import java.util.List;
/* renamed from: av  reason: default package */
/* loaded from: classes.dex */
public class av extends PopupWindow implements View.OnClickListener {
    private ShareContent a;
    private IBaiduListener b;
    private Context c;
    private SocialShare.Theme d;
    private boolean e;

    public av(Context context, SocialShare.Theme theme, boolean z) {
        super(context);
        View listStyleShareMenu;
        this.c = context;
        this.d = theme;
        this.e = z;
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(-1);
        setHeight(-1);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setOnClickListener(this);
        relativeLayout.setBackgroundDrawable(new ColorDrawable(-1845493760));
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(relativeLayout);
        setFocusable(true);
        relativeLayout.setFocusableInTouchMode(true);
        relativeLayout.setOnKeyListener(new aw(this));
        if (z) {
            listStyleShareMenu = new WeixinShareMenu(context, theme, this);
        } else {
            List supportedMediaTypes = SocialShareConfig.getInstance(context).getSupportedMediaTypes();
            if (Utils.isEmpty(supportedMediaTypes)) {
                throw new IllegalArgumentException("config item for [supported_medias] shouldn't be empty");
            }
            listStyleShareMenu = supportedMediaTypes.size() < 5 ? new ListStyleShareMenu(context, theme, this) : new l(context, theme, this);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(listStyleShareMenu, layoutParams);
        update();
    }

    public SocialShare.Theme a() {
        return this.d;
    }

    public void a(View view, ShareContent shareContent, IBaiduListener iBaiduListener) {
        this.a = shareContent;
        this.b = iBaiduListener;
        showAtLocation(view, 81, 0, 0);
    }

    public boolean b() {
        return this.e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (TextUtils.isEmpty(str)) {
            dismiss();
        } else if (str.equalsIgnoreCase("cancel")) {
            dismiss();
        } else {
            SocialShare.getInstance(this.c).share(this.a, str, (IBaiduListener) new ax(this, this.b), true);
        }
    }
}
