package d.a.j0.z0;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static BaseWebView f50988a;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseWebView f50989a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, BaseWebView baseWebView) {
            super(i2);
            this.f50989a = baseWebView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BaseWebView baseWebView;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921024 || (baseWebView = this.f50989a) == null) {
                return;
            }
            baseWebView.reload();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f50990a;

        /* renamed from: b  reason: collision with root package name */
        public String f50991b;

        public b(String str, String str2) {
            this.f50990a = "";
            this.f50991b = "";
            this.f50990a = str;
            this.f50991b = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f50990a;
                if (str == null) {
                    if (bVar.f50990a != null) {
                        return false;
                    }
                } else if (!str.equals(bVar.f50990a)) {
                    return false;
                }
                String str2 = this.f50991b;
                if (str2 == null) {
                    if (bVar.f50991b != null) {
                        return false;
                    }
                } else if (!str2.equals(bVar.f50991b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f50990a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f50991b;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
    }

    public static String a(String str) {
        if (d.a.c.e.p.k.isEmpty(str) || str.contains("page_type")) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("page_type");
        sb.append("=");
        sb.append(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
        return sb.toString();
    }

    public static String b() {
        if (Build.VERSION.SDK_INT >= 17) {
            return WebSettings.getDefaultUserAgent(TbadkCoreApplication.getInst()) + " tieba/" + TbConfig.getVersion();
        }
        return "";
    }

    public static String c(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = indexOf + str2.length();
            int i2 = length;
            while (i2 < str.length() && str.charAt(i2) != '&') {
                i2++;
            }
            try {
                return URLDecoder.decode(str.substring(length, i2));
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return "";
            }
        }
        return "";
    }

    public static String d(String str, String str2) {
        String[] split;
        String str3 = "";
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (split = str.split("[?]")) != null && split.length >= 2) {
            for (int i2 = 1; i2 < split.length; i2++) {
                String[] split2 = split[i2].split("&");
                if (split2 != null && split2.length > 0) {
                    int length = split2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            String[] split3 = split2[i3].split("=");
                            if (split3.length == 2) {
                                String str4 = split3[0];
                                String str5 = split3[1];
                                if (str2.equals(str4)) {
                                    try {
                                        str3 = URLDecoder.decode(str5);
                                        break;
                                    } catch (Exception unused) {
                                        str3 = str5;
                                    }
                                }
                            }
                            i3++;
                        }
                    }
                }
            }
        }
        return str3;
    }

    @Deprecated
    public static String e() {
        f();
        BaseWebView baseWebView = f50988a;
        if (baseWebView == null || baseWebView.getSettings() == null) {
            return null;
        }
        return f50988a.getSettings().getUserAgentString();
    }

    public static void f() {
        try {
            if (f50988a == null) {
                f50988a = new BaseWebView(TbadkCoreApplication.getInst());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void g(BaseWebView baseWebView, BdUniqueId bdUniqueId) {
        if (baseWebView == null) {
            return;
        }
        a aVar = new a(2921024, baseWebView);
        if (bdUniqueId != null) {
            aVar.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://");
    }

    public static Bundle i(String str) {
        URL url;
        String query;
        String[] split;
        if (StringUtils.isNull(str)) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            url = new URL(str);
            query = url.getQuery();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        if (StringUtils.isNull(query) || StringUtils.isNull(url.getPath()) || (split = query.split("&")) == null) {
            return null;
        }
        bundle.putString("path", url.getPath());
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2 != null && split2.length == 2 && !StringUtils.isNull(split2[0])) {
                bundle.putString(split2[0], split2[1]);
            }
        }
        return bundle;
    }
}
