package d.a.n0.s.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.livesdk.api.share.Share;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import d.a.c.e.p.k;
import d.a.c.e.p.q;
import d.a.n0.s.g.b;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f54456a;

    /* renamed from: b  reason: collision with root package name */
    public c f54457b;

    /* renamed from: c  reason: collision with root package name */
    public d f54458c;

    /* renamed from: f  reason: collision with root package name */
    public b f54461f;

    /* renamed from: d  reason: collision with root package name */
    public String f54459d = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);

    /* renamed from: e  reason: collision with root package name */
    public String f54460e = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.f54459d;

    /* renamed from: g  reason: collision with root package name */
    public b.InterfaceC1215b f54462g = new a();

    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC1215b {
        public a() {
        }

        @Override // d.a.n0.s.g.b.InterfaceC1215b
        public void a(ShareItem shareItem) {
            g.this.f54458c.a(g.this.q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
        }
    }

    public g(Context context, c cVar) {
        e eVar;
        this.f54457b = null;
        this.f54458c = null;
        this.f54456a = context;
        this.f54457b = cVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001445, e.class);
        if (runTask.getData() == null || (eVar = (e) runTask.getData()) == null) {
            return;
        }
        this.f54458c = eVar.a(this.f54456a, this.f54457b);
    }

    public static String d(String str, String str2) {
        String str3;
        if (str.contains("?")) {
            str3 = "&";
        } else {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    public static boolean e(Context context) {
        return g();
    }

    public static boolean g() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001445);
    }

    public static String o(String str, String str2) {
        return p(str, "copy", str2);
    }

    public static String p(String str, String str2, String str3) {
        String c2;
        if (k.isEmpty(str)) {
            str = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        }
        String d2 = d(d(str, "sfc=" + str2), "client_type=2");
        String d3 = d(d2, "client_version=" + TbConfig.getVersion());
        String d4 = d(d3, "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                c2 = q.c(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                c2 = q.c(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return d(d4, "unique=" + c2);
        }
        return d4;
    }

    public final String c(String str, int i2, int i3, String str2) {
        int min;
        if (str == null) {
            return str2;
        }
        if (Math.min((i2 - str2.length()) - i3, str.length()) < str.length()) {
            return str.substring(0, min - 1) + (StringHelper.STRING_MORE + str2);
        }
        return str + str2;
    }

    public boolean f(String str) {
        File file;
        if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
            try {
                file = new File(new URI(str));
            } catch (URISyntaxException unused) {
            }
            return file.isFile() && file.exists();
        }
        return false;
    }

    public void h(ShareItem shareItem) {
        if (this.f54458c == null || shareItem == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 32, shareItem.b0 ? this.f54459d : "");
        this.f54458c.a(q(shareItem, Share.QQFRIEND), 8, true);
    }

    public void i(ShareItem shareItem) {
        if (this.f54458c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 32, shareItem.b0 ? this.f54459d : "");
        this.f54458c.a(q(shareItem, "qzone"), 4, true);
    }

    public void j(ShareItem shareItem) {
        if (this.f54458c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.b0 ? this.f54459d : "");
        this.f54458c.a(q(shareItem, "renren"), 7, true);
    }

    public void k(ShareItem shareItem) {
        if (this.f54458c == null) {
            return;
        }
        if (!d.a.n0.s.g.a.b(TbadkApplication.getInst().getApplicationContext(), 6)) {
            BdToast.c(TbadkApplication.getInst().getApplicationContext(), TbadkApplication.getInst().getApplicationContext().getText(R.string.share_sina_weibo_not_install)).q();
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.b0 ? this.f54460e : "");
        this.f54458c.a(q(shareItem, "sina_weibo"), 6, true);
    }

    public void l(ShareItem shareItem) {
        if (this.f54458c == null) {
            return;
        }
        shareItem.s = c(shareItem.s, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 20, shareItem.b0 ? this.f54459d : "");
        this.f54458c.a(q(shareItem, "tencent_weibo"), 5, true);
    }

    public void m(ShareItem shareItem) {
        if (this.f54458c == null || shareItem == null) {
            return;
        }
        if (StringUtils.isNull(shareItem.K)) {
            shareItem.s = c(shareItem.s, 80, 20, shareItem.b0 ? this.f54459d : "");
        }
        if (shareItem.f0 && !k.isEmpty(shareItem.e0)) {
            shareItem.v = Uri.parse(shareItem.e0);
            this.f54458c.a(q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
        } else if (shareItem.f0 && k.isEmpty(shareItem.e0) && !k.isEmpty(shareItem.K) && !"0".equals(shareItem.K)) {
            if (this.f54461f == null) {
                b bVar = new b();
                this.f54461f = bVar;
                bVar.c(this.f54462g);
            }
            this.f54461f.b(shareItem);
        } else {
            if (shareItem.y == 4) {
                if (this.f54461f == null) {
                    this.f54461f = new b();
                }
                this.f54461f.b(shareItem);
            }
            this.f54458c.a(q(shareItem, ThirdPartyUtil.TYPE_WEIXIN), 3, false);
        }
    }

    public void n(ShareItem shareItem) {
        if (this.f54458c == null || shareItem == null) {
            return;
        }
        shareItem.s = c(shareItem.s, 80, 20, shareItem.b0 ? this.f54459d : "");
        this.f54458c.a(q(shareItem, Share.WEIXIN_TIMELINE), 2, false);
    }

    public final ShareItem q(ShareItem shareItem, String str) {
        if (shareItem == null) {
            return null;
        }
        Uri uri = shareItem.v;
        if ((uri == null || uri.equals("")) && shareItem.c() == null) {
            str.startsWith(ThirdPartyUtil.TYPE_WEIXIN);
            shareItem.v = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
        }
        Uri uri2 = shareItem.v;
        if (uri2 != null && !uri2.equals("")) {
            String uri3 = shareItem.v.toString();
            if (!f(uri3) && !r(uri3)) {
                shareItem.v = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            } else {
                shareItem.v = Uri.parse(uri3);
                d(uri3, "sfc=" + str);
            }
        }
        if (shareItem.c0) {
            shareItem.t = p(shareItem.t, str, shareItem.K);
        }
        return shareItem;
    }

    public final boolean r(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(",");
        if (UrlManager.getInstance().UrlValidated(str)) {
            if (split == null || split.length <= 0) {
                return true;
            }
            for (String str2 : split) {
                if (str2 != null && !str2.equals("") && (str.contains(str2) || str.contains(str2.toUpperCase()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
