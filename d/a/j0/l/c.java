package d.a.j0.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.j0.r.s.a;
import d.a.j0.z0.n0;
import d.a.k0.s2.y;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.j0.l.a.f(TbadkCoreApplication.getInst());
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements UrlManager.UrlWebDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlWebDealListener
        public void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlManager.UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
            if (z2) {
                c.m(tbPageContext, str2, null, false, true, true, true);
            } else {
                c.n(tbPageContext, str2, str, z, true, true, true);
            }
        }
    }

    /* renamed from: d.a.j0.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1117c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            Uri parse;
            Bundle i2;
            String str;
            if (tbPageContext == null || strArr == null || strArr.length == 0) {
                return 3;
            }
            String str2 = strArr[0];
            if (StringUtils.isNull(str2)) {
                return 3;
            }
            str2.toLowerCase();
            String str3 = strArr.length > 2 ? strArr[2] : null;
            String str4 = strArr.length > 1 ? strArr[1] : null;
            if (str2.startsWith("tel:")) {
                UtilHelper.callPhone(tbPageContext.getPageActivity(), str2.substring(4));
                return 0;
            } else if (n0.h(str2) && str2.toLowerCase().endsWith(".apk")) {
                c.l(tbPageContext.getPageActivity(), str2);
                return 0;
            } else {
                String str5 = "";
                if (str2.contains("http://tieba.baidu.com/mo/q/hotMessage?topic_id=")) {
                    Uri parse2 = Uri.parse(str2);
                    String queryParameter = parse2.getQueryParameter("topic_id");
                    String queryParameter2 = parse2.getQueryParameter(IntentConfig.TOPIC_NAME);
                    if (TextUtils.isEmpty(queryParameter) || !d.a.j0.p0.b.h(true)) {
                        return 3;
                    }
                    if (strArr != null && strArr.length > 1 && !StringUtils.isNull(strArr[1])) {
                        str5 = strArr[1];
                    }
                    tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter, queryParameter2, str5)));
                    return 0;
                } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    String substring = str2.substring(4);
                    if (str2.contains("body=")) {
                        str = n0.c(str2, "body=");
                        int indexOf = substring.indexOf("?");
                        if (indexOf >= 1 && indexOf <= substring.length()) {
                            str5 = substring.substring(0, indexOf);
                        }
                    } else {
                        str = "";
                        str5 = substring;
                    }
                    UtilHelper.smsTo(tbPageContext.getPageActivity(), str5, str);
                    return 0;
                } else if (str2.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_OUTER)) {
                    d.a.j0.l.a.j(tbPageContext.getPageActivity(), str2);
                    return 1;
                } else if (UtilHelper.isNativeAdURL(str2)) {
                    y.d(tbPageContext.getPageActivity(), str2, null, null);
                    return 1;
                } else if (!str2.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE) && !str2.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE_2)) {
                    if ((str2.contains(UrlSchemaHelper.SCHEMA_TYPE_FINISH_THIS_PAGE) || str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_CLOSE_WEBVIEW)) && tbPageContext.getPageActivity() != null) {
                        tbPageContext.getPageActivity().finish();
                        return 1;
                    } else if (str2.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str2.contains(UrlSchemaHelper.TBEAN_TOAST) && (tbPageContext instanceof Activity)) {
                        UtilHelper.showToast(tbPageContext.getPageActivity(), R.string.buy_sucess);
                        ((Activity) tbPageContext).finish();
                        return 0;
                    } else if (str2.startsWith("tieba://focusforum")) {
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        return 0;
                    } else if (str2.startsWith("baiduxiuba://")) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse(str2));
                        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        tbPageContext.getPageActivity().startActivity(intent);
                        return 0;
                    } else if (str2.contains(UrlSchemaHelper.AUTO_PAY_MEMBER_SUCC_URL) && str2.contains(UrlSchemaHelper.AUTO_PAY_MEMBER_SUCC_PARAM)) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016525, Boolean.TRUE));
                        tbPageContext.getPageActivity().finish();
                        return 1;
                    } else if (str2.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str2.contains(UrlSchemaHelper.GOTO_TDOU_PAY_BUNDING_PHONE)) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001359, n0.c(str2, "bindid=")));
                        tbPageContext.getPageActivity().finish();
                        return 1;
                    } else if (str2.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str2.contains(UrlSchemaHelper.CHANGE_YINJI_SUCCESS) && (i2 = n0.i(str2)) != null && UrlSchemaHelper.CHANGE_YINJI_SUCCESS.equalsIgnoreCase(i2.getString("path"))) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001372));
                        return 0;
                    } else if (str2.startsWith(UrlSchemaHelper.SCHEME_TYPE_ACCOUNT_SAFE) && tbPageContext.getPageActivity() != null) {
                        MessageManager.getInstance().runTask(2921329, null, tbPageContext.getPageActivity());
                        return 0;
                    } else if (str2.contains(UrlSchemaHelper.FROM_FORUM_SQUARE) && tbPageContext.getPageActivity() != null) {
                        ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity());
                        forumSquareActivityConfig.setUri(Uri.parse(str2));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
                        return 0;
                    } else if (str2.contains(UrlSchemaHelper.FROM_ENTER_FORUM) && tbPageContext.getPageActivity() != null) {
                        MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1);
                        String queryParameter3 = Uri.parse(str2).getQueryParameter(d.a.j0.a.f.z);
                        if (!k.isEmpty(queryParameter3)) {
                            createNormalCfg.setSubTab(0, queryParameter3);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, createNormalCfg));
                        return 0;
                    } else {
                        if (str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                            c.m(tbPageContext, d.a.j0.l.a.g(str2.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, ""), str3), null, false, true, true, true);
                        } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                            c.m(tbPageContext, d.a.j0.l.a.g(str2.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, ""), str3), null, false, true, true, true);
                        } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TOPIC)) {
                            c.m(tbPageContext, str4, str2.substring(6), false, true, true, false);
                        } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_ZB)) {
                            c.m(tbPageContext, str2.substring(3), tbPageContext.getString(R.string.photo_live_tips), false, true, false, false);
                        } else if (str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIST)) {
                            String substring2 = str2.substring(5);
                            if (!TextUtils.isEmpty(substring2)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring2, str3)));
                            }
                        } else if (str2.contains(UrlSchemaHelper.SCHEMA_NAITVE_H5) && (parse = Uri.parse(str2)) != null) {
                            c.m(tbPageContext, parse.getQueryParameter("url"), null, false, true, false, false);
                            return 0;
                        }
                        return 3;
                    }
                } else {
                    d.a.j0.l.a.l(tbPageContext.getPageActivity(), str2);
                    return 1;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f49407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49409g;

        public d(TbPageContext tbPageContext, String str, String str2) {
            this.f49407e = tbPageContext;
            this.f49408f = str;
            this.f49409g = str2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            d.a.j0.l.a.m(this.f49407e.getPageActivity(), this.f49408f, this.f49409g);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {
        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            PbActivityConfig createNormalCfg;
            if (strArr != null && strArr[0] != null) {
                Uri parse = Uri.parse(strArr[0]);
                if ("lego".equalsIgnoreCase(parse.getAuthority())) {
                    return c.d(tbPageContext, parse, null, false) ? 0 : 3;
                } else if ("pb".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter = parse.getQueryParameter("tId");
                    String queryParameter2 = parse.getQueryParameter("view_type");
                    if (queryParameter == null || queryParameter.length() <= 0) {
                        return 3;
                    }
                    if (queryParameter2 != null && (queryParameter2.equals("2") || queryParameter2.equals("3"))) {
                        createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createViewTypeCfg(queryParameter, Boolean.valueOf(queryParameter2.equals("2")).booleanValue(), Boolean.valueOf(!queryParameter2.equals("3")).booleanValue(), "lego");
                        createNormalCfg.setVideo_source("frs");
                    } else {
                        createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter, null, "lego");
                    }
                    tbPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return 0;
                } else if ("frs".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter3 = parse.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
                    if (queryParameter3 == null || queryParameter3.length() <= 0) {
                        return 3;
                    }
                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter3, "lego");
                    createNormalCfg2.setCallFrom(12);
                    tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg2));
                    return 0;
                } else if ("person".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter4 = parse.getQueryParameter("uid");
                    String queryParameter5 = parse.getQueryParameter("uname");
                    if (queryParameter4 == null || queryParameter4.length() <= 0) {
                        return 3;
                    }
                    tbPageContext.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), queryParameter4, queryParameter5)));
                    return 0;
                } else if ("topic".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter6 = parse.getQueryParameter("topic_id");
                    String queryParameter7 = parse.getQueryParameter(IntentConfig.TOPIC_NAME);
                    if (queryParameter6 != null && queryParameter7 != null) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter6, queryParameter7, null)));
                        return 1;
                    } else if (queryParameter6 != null) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter6, null, null)));
                        return 1;
                    }
                }
            }
            return 3;
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr[0] != null) {
                String str = strArr[0];
                String str2 = null;
                if (!str.startsWith("http://tieba.baidu.com/mo/q/blitz/index#") && !str.startsWith("https://tieba.baidu.com/mo/q/blitz/index#")) {
                    if (str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#") || str.startsWith("https://tieba.baidu.com/tb/zt/lego/h5/#")) {
                        int indexOf = str.indexOf("page/") + 5;
                        int indexOf2 = str.indexOf("?");
                        if (indexOf > 5 && indexOf2 > indexOf) {
                            str2 = str.substring(indexOf, indexOf2);
                        }
                        if (indexOf2 > -1) {
                            if (c.d(tbPageContext, Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_LEGO + str.substring(indexOf2 + 1)), str2, true)) {
                                return 0;
                            }
                        }
                        return 3;
                    }
                    return 3;
                }
                int indexOf3 = str.indexOf("page/") + 5;
                int indexOf4 = str.indexOf("?");
                if (indexOf3 > 5 && indexOf4 > indexOf3) {
                    str2 = str.substring(indexOf3, indexOf4);
                }
                if (indexOf4 > -1) {
                    if (c.d(tbPageContext, Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_LEGO + str.substring(indexOf4 + 1)), str2, false)) {
                        return 0;
                    }
                }
            }
            return 3;
        }
    }

    public static boolean d(TbPageContext<?> tbPageContext, Uri uri, String str, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (tbPageContext != null && uri != null) {
            String queryParameter = (str == null || str.length() == 0) ? uri.getQueryParameter("page_id") : str;
            String queryParameter2 = uri.getQueryParameter("page_type");
            String queryParameter3 = uri.getQueryParameter(LegoListActivityConfig.ITEM_ID);
            String queryParameter4 = uri.getQueryParameter("rn");
            String queryParameter5 = uri.getQueryParameter("params");
            String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
            String queryParameter7 = uri.getQueryParameter(LegoListActivityConfig.NEXT_PAGE);
            String queryParameter8 = uri.getQueryParameter("lego_version");
            String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
            String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
            String queryParameter11 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
            String queryParameter12 = uri.getQueryParameter("source");
            if (TextUtils.isEmpty(queryParameter12)) {
                queryParameter12 = "unknown";
            }
            String str2 = queryParameter12;
            if ((!z || g(queryParameter8)) && queryParameter != null && queryParameter2 != null && queryParameter.length() > 0 && queryParameter2.length() > 0) {
                try {
                    int parseInt = Integer.parseInt(queryParameter2);
                    long parseLong = Long.parseLong(queryParameter);
                    try {
                        i2 = Integer.parseInt(queryParameter4);
                    } catch (Exception unused) {
                        i2 = 20;
                    }
                    try {
                        i3 = Integer.parseInt(queryParameter9);
                    } catch (Exception unused2) {
                        i3 = 0;
                    }
                    try {
                        i4 = Integer.parseInt(queryParameter10);
                    } catch (Exception unused3) {
                        i4 = 0;
                    }
                    String queryParameter13 = i4 == 1 ? uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO) : "";
                    try {
                        i5 = Integer.parseInt(queryParameter11);
                    } catch (Exception unused4) {
                        i5 = 0;
                    }
                    LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parseLong, parseInt, queryParameter3, i3, i2, queryParameter5);
                    createNormalCfg.addLandingPageParams(queryParameter13, queryParameter6, queryParameter7, i4, i5, str2);
                    tbPageContext.sendMessage(new CustomMessage(2016447, createNormalCfg));
                    return true;
                } catch (Exception unused5) {
                }
            }
        }
        return false;
    }

    public static void e() {
        MessageManager.getInstance().registerListener(2005016, new a(0));
        UrlManager.getInstance().setWebListener(new b());
        SwitchManager.getInstance().addSwitchData(new d.a.c.e.f.b("switch_mbaidu_startup", 1, null));
        i();
        j();
        k();
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return "lego".equalsIgnoreCase(Uri.parse(str).getAuthority());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.VERSION_NAME;
        }
        return TbConfig.getLegoLibVersion().compareTo(str) >= 0;
    }

    public static String h(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
        if (checkUrl == null) {
            checkUrl = "http://tieba.baidu.com/mo/q/checkurl?url=";
        } else if (checkUrl.trim().length() == 0) {
            return str;
        }
        if (str.startsWith(checkUrl)) {
            return str;
        }
        return checkUrl + o(str);
    }

    public static void i() {
        UrlManager.getInstance().addListener(new C1117c());
    }

    public static void j() {
        UrlManager.getInstance().addListener(new f());
    }

    public static void k() {
        UrlManager.getInstance().addListener(new g());
    }

    public static boolean l(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                context.startActivity(intent);
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void m(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String h2 = h(str);
        if (z) {
            d.a.j0.s.h.a.d(tbPageContext, new d(tbPageContext, str2, h2), new e(), h2);
        } else {
            d.a.j0.l.a.m(tbPageContext.getPageActivity(), str2, h2);
        }
    }

    public static void n(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_1", null);
        m(tbPageContext, str, str2, z, z2, z3, z4);
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = new String(str.getBytes(), StandardCharsets.UTF_8);
            try {
                return URLEncoder.encode(str2, "UTF-8");
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return str;
        }
    }
}
