package d.a.n0.s.d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import d.a.c.e.p.k;
import d.a.n0.s.e.f;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static b o;
    public static Date p;
    public static Handler q = new a();
    public d.a.n0.s.e.f j;
    public String l;
    public String m;
    public String n;

    /* renamed from: b  reason: collision with root package name */
    public int f54336b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f54337c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f54338d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f54339e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f54340f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f54341g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f54342h = 0;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.s.e.f f54343i = new d.a.n0.s.e.f();
    public boolean k = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f54335a = TbadkCoreApplication.getInst().getApp();

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.g0().V(b.g0().B());
            }
        }
    }

    public static boolean M() {
        if (d.d().x()) {
            Calendar calendar = Calendar.getInstance();
            int i2 = (calendar.get(11) * 60) + calendar.get(12);
            String[] split = d.d().g().split(":");
            int parseInt = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
            String[] split2 = d.d().f().split(":");
            int parseInt2 = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
            if (parseInt < parseInt2) {
                if (i2 < parseInt || i2 > parseInt2) {
                    return false;
                }
            } else if (parseInt <= parseInt2) {
                return false;
            } else {
                if ((i2 < parseInt || i2 > 1439) && (i2 < 0 || i2 > parseInt2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean R() {
        if (p == null) {
            p = new Date();
            return true;
        }
        Date date = new Date();
        if (date.getTime() - p.getTime() < 10000) {
            return false;
        }
        p = date;
        return true;
    }

    public static b g0() {
        if (o == null) {
            o = new b();
        }
        return o;
    }

    public int A() {
        return this.f54337c;
    }

    public d.a.n0.s.e.f B() {
        return this.j;
    }

    public int C(int i2) {
        if (i2 == 12 || i2 == 13 || i2 == 28) {
            return 2;
        }
        if (i2 != 29) {
            if (i2 != 2000) {
                switch (i2) {
                    case 15:
                    case 18:
                    case 19:
                        return 2;
                    case 16:
                    case 17:
                        return 1;
                    default:
                        switch (i2) {
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                return 3;
                            default:
                                return 0;
                        }
                }
            }
            return 2;
        }
        return 3;
    }

    public String D() {
        return "3222425470";
    }

    public int E() {
        return this.f54336b + this.f54337c + this.f54338d + this.f54339e + this.f54341g + this.f54342h;
    }

    public d.a.n0.s.e.f F() {
        return this.f54343i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent G(int i2, boolean z) {
        String str;
        if (z) {
            Set<String> keySet = this.f54343i.h().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
                Intent intent = new Intent();
                if (!UtilHelper.isFlyMeOs()) {
                    intent.setClass(this.f54335a, DealIntentActivity.class);
                } else {
                    intent.setClass(this.f54335a, DealIntentService.class);
                }
                intent.putExtra(DealIntentService.KEY_CLASS, 5);
                intent.putExtra("KeyOfNotiId", i2);
                intent.putExtra("agree_me", this.f54336b);
                intent.putExtra("at_me", this.f54338d);
                intent.putExtra("reply_me", this.f54337c);
                intent.putExtra("fans", this.f54341g);
                intent.putExtra("chat", x());
                intent.putExtra("group_msg", this.f54343i.j() - this.f54343i.l());
                intent.putExtra("group_msg_validate", this.f54343i.q());
                intent.putExtra("group_msg_updates", this.f54343i.n());
                intent.putExtra("officialbar_msg", this.f54343i.u());
                intent.putExtra("privateGid", str);
                return intent;
            }
        }
        str = "";
        Intent intent2 = new Intent();
        if (!UtilHelper.isFlyMeOs()) {
        }
        intent2.putExtra(DealIntentService.KEY_CLASS, 5);
        intent2.putExtra("KeyOfNotiId", i2);
        intent2.putExtra("agree_me", this.f54336b);
        intent2.putExtra("at_me", this.f54338d);
        intent2.putExtra("reply_me", this.f54337c);
        intent2.putExtra("fans", this.f54341g);
        intent2.putExtra("chat", x());
        intent2.putExtra("group_msg", this.f54343i.j() - this.f54343i.l());
        intent2.putExtra("group_msg_validate", this.f54343i.q());
        intent2.putExtra("group_msg_updates", this.f54343i.n());
        intent2.putExtra("officialbar_msg", this.f54343i.u());
        intent2.putExtra("privateGid", str);
        return intent2;
    }

    public Intent H(f.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f54335a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f54335a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 36);
        intent.putExtra("tab_id", 1);
        return intent;
    }

    public Intent I(int i2) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f54335a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f54335a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 24);
        intent.putExtra("KeyOfNotiId", i2);
        intent.putExtra("gift_num", this.f54342h);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent J(f.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f54335a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f54335a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 27);
        intent.putExtra("uid", aVar.f54422a);
        intent.putExtra("uname", aVar.f54426e);
        intent.putExtra("user_type", aVar.f54427f);
        return intent;
    }

    public Intent K(int i2) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f54335a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f54335a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 35);
        intent.putExtra("KeyOfNotiId", i2);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent L() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f54335a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f54335a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.f54343i.o());
        return intent;
    }

    public boolean N(String str) {
        return "3222425470".equals(str);
    }

    public final void O(f.a aVar, int i2) {
        PendingIntent service;
        Intent S = S(aVar);
        if (S != null && S.getDataString() != null && S.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            S.setFlags(276824064);
            NotificationHelper.showNotification(this.f54335a, i2, aVar.f54423b, aVar.f54424c, aVar.f54425d, PendingIntent.getActivity(this.f54335a, i2, S, 134217728), false);
            return;
        }
        if (S == null) {
            S = J(aVar);
        }
        if (S == null) {
            S = H(aVar);
        }
        if (S == null) {
            return;
        }
        if (UtilHelper.isFlyMeOs()) {
            service = PendingIntent.getActivity(this.f54335a, i2, S, 134217728);
        } else {
            service = PendingIntent.getService(this.f54335a, i2, S, 134217728);
        }
        j(C(i2), i2);
        NotificationHelper.showNotification(this.f54335a, i2, aVar.f54423b, aVar.f54424c, aVar.f54425d, service, false);
    }

    public final void P(int i2, String str, String str2, String str3) {
        Q(i2, str, str2, str3, false);
    }

    public final void Q(int i2, String str, String str2, String str3, boolean z) {
        Intent G;
        PendingIntent service;
        if (this.k) {
            if (i2 == 23 && this.f54342h > 0) {
                G = I(i2);
            } else if (i2 == 26 && this.f54341g > 0) {
                G = K(i2);
            } else if (i2 == 18) {
                G = L();
            } else if (i2 == 24) {
                G = G(i2, z);
                G.putExtra("tab_id", 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i2 != 16 && i2 != 17 && i2 != 18) {
                G = G(i2, z);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                G = G(i2, z);
                G.putExtra("tab_id", 2);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            G.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.f54335a, i2, G, 134217728);
            } else {
                service = PendingIntent.getService(this.f54335a, i2, G, 134217728);
            }
            j(C(i2), i2);
            NotificationHelper.showNotification(this.f54335a, i2, str, str2, str3, service, false);
        }
    }

    public Intent S(f.a aVar) {
        ImMessageCenterPojo i2;
        if (aVar != null && (i2 = d.a.o0.f1.k.b.o().i(aVar.f54422a, aVar.f54427f)) != null && i2.getLast_content() != null) {
            try {
                String lastTaskId = i2.getLastTaskId();
                String lastServiceId = i2.getLastServiceId();
                JSONArray jSONArray = new JSONArray(i2.getLastContentRawData());
                if (jSONArray.length() != 1) {
                    return null;
                }
                String optString = ((JSONObject) jSONArray.get(0)).optString("url");
                if (StringUtils.isNull(optString)) {
                    return null;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(optString);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (!StringUtils.isNull(group)) {
                        Intent intent = new Intent();
                        if (UtilHelper.isFlyMeOs()) {
                            intent.setClass(this.f54335a, DealIntentActivity.class);
                        } else {
                            intent.setClass(this.f54335a, DealIntentService.class);
                        }
                        intent.putExtra(DealIntentService.KEY_CLASS, 1);
                        intent.putExtra("id", group);
                        intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
                        intent.putExtra("key_start_from", 7);
                        intent.putExtra("gid", aVar.f54422a);
                        intent.putExtra("task_id", lastTaskId);
                        intent.putExtra("service_id", lastServiceId);
                        return intent;
                    }
                } else {
                    if (!optString.contains("mo/q/hotMessage") && !optString.contains("mo/q/newtopic")) {
                        if (optString.contains("open_wb_view=1")) {
                            Intent intent2 = new Intent();
                            if (UtilHelper.isFlyMeOs()) {
                                intent2.setClass(this.f54335a, DealIntentActivity.class);
                            } else {
                                intent2.setClass(this.f54335a, DealIntentService.class);
                            }
                            intent2.putExtra(DealIntentService.KEY_CLASS, 0);
                            intent2.putExtra("url", optString.trim());
                            intent2.putExtra("task_id", lastTaskId);
                            intent2.putExtra("service_id", lastServiceId);
                            return intent2;
                        } else if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                            return Intent.parseUri(optString, 1);
                        } else {
                            if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                                Intent intent3 = new Intent();
                                if (UtilHelper.isFlyMeOs()) {
                                    intent3.setClass(this.f54335a, DealIntentActivity.class);
                                } else {
                                    intent3.setClass(this.f54335a, DealIntentService.class);
                                }
                                intent3.putExtra(DealIntentService.KEY_CLASS, 39);
                                String paramStr = UrlManager.getParamStr(optString);
                                if (!TextUtils.isEmpty(paramStr)) {
                                    Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                                    if (!paramPair.isEmpty()) {
                                        String str = paramPair.get("tid");
                                        String str2 = paramPair.get("pid");
                                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                            intent3.putExtra("thread_id", str);
                                            intent3.putExtra("post_id", str2);
                                            return intent3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Intent intent4 = new Intent();
                    if (UtilHelper.isFlyMeOs()) {
                        intent4.setClass(this.f54335a, DealIntentActivity.class);
                    } else {
                        intent4.setClass(this.f54335a, DealIntentService.class);
                    }
                    intent4.putExtra(DealIntentService.KEY_CLASS, 30);
                    intent4.putExtra("jump_url", optString);
                    intent4.putExtra("task_id", lastTaskId);
                    intent4.putExtra("service_id", lastServiceId);
                    return intent4;
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return null;
    }

    public final void T(NewsNotifyMessage newsNotifyMessage) {
    }

    public void U(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (i2 == this.f54336b && i3 == this.f54337c && i4 == this.f54338d && i5 == this.f54339e && i6 == this.f54341g && i7 == this.f54340f && i8 == this.f54342h) {
            return;
        }
        int i14 = this.f54336b;
        int i15 = 2;
        int i16 = (i2 > i14 || i3 > (i12 = this.f54337c) || i4 > (i13 = this.f54338d) || i5 > this.f54339e || i6 > this.f54341g || i7 > this.f54340f || i8 > this.f54342h) ? 1 : (i2 < i14 || i3 < i12 || i4 < i13) ? 2 : 0;
        if (i2 <= this.f54336b || !d.d().w()) {
            i9 = i2 < this.f54336b ? 2 : 0;
        } else {
            i9 = 1;
        }
        if (i3 <= this.f54337c || !d.d().t()) {
            i10 = i3 < this.f54337c ? 2 : 0;
        } else {
            i10 = 1;
        }
        if (i4 <= this.f54338d || !d.d().o()) {
            i11 = i4 < this.f54338d ? 2 : 0;
        } else {
            i11 = 1;
        }
        int i17 = i5 > this.f54339e ? 1 : 0;
        int i18 = i6 > this.f54341g ? 1 : 0;
        int i19 = i8 > this.f54342h ? 1 : 0;
        this.f54336b = i2;
        this.f54337c = i3;
        this.f54338d = i4;
        this.f54339e = i5;
        this.f54341g = i6;
        this.f54340f = i7;
        this.f54342h = i8;
        if (E() <= 0) {
            i16 = 2;
            i18 = 2;
            i9 = 2;
            i10 = 2;
            i11 = 2;
            i17 = 2;
        } else {
            i15 = i19;
        }
        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
            return;
        }
        a();
        h0(i15, 23);
        h0(i17, 16);
        h0(i16, 17);
        h0(i10, 24);
        h0(i11, 25);
        h0(i18, 26);
        h0(i9, 29);
    }

    public void V(d.a.n0.s.e.f fVar) {
        if (fVar == null) {
            return;
        }
        this.f54343i = fVar;
        this.f54339e = (fVar.j() - fVar.l()) + fVar.w() + fVar.t() + fVar.s();
        b(fVar);
        int i2 = 0;
        if (fVar.z()) {
            this.j = null;
            q.removeMessages(0);
        }
        if (fVar.z()) {
            if (d.d().n() && d.d().e() > 0) {
                i2 = fVar.j() - fVar.l();
            }
            long w = (!d.d().p() || d.d().e() <= 0) ? 0L : fVar.w();
            if ((i2 > 0 || w > 0) && ((i2 > fVar.m() - fVar.l() && i2 > 0) || w > fVar.x())) {
                i0(1, 16, fVar);
            }
            int u = fVar.u();
            if (u > 0 && u > fVar.v()) {
                i0(1, 19, fVar);
            }
            if (fVar.n() > fVar.p() || fVar.q() > fVar.r()) {
                if (fVar.n() > fVar.p() && fVar.q() == fVar.r() && k0()) {
                    return;
                }
                if (fVar.n() == fVar.p() && fVar.q() > fVar.r() && l0()) {
                    return;
                }
                i0(1, 17, fVar);
            }
        }
    }

    public void W(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 == this.f54336b && i3 == this.f54337c && i4 == this.f54338d && i5 == this.f54339e && i6 == this.f54341g && this.f54342h == i7) {
            return;
        }
        this.f54336b = i2;
        this.f54337c = i3;
        this.f54338d = i4;
        this.f54339e = i5;
        this.f54341g = i6;
        this.f54342h = i7;
        a();
        if (E() <= 0) {
            h0(2, 16);
            h0(2, 17);
        }
    }

    public void X(boolean z) {
        if (z) {
            U(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.f54336b = 0;
        this.f54337c = 0;
        this.f54338d = 0;
        this.f54339e = 0;
        this.f54341g = 0;
        this.f54340f = 0;
    }

    public void Y(int i2) {
        if (i2 >= 0) {
            U(i2, this.f54337c, this.f54338d, this.f54339e, this.f54341g, this.f54340f, this.f54342h);
        }
    }

    public void Z(int i2) {
        if (i2 >= 0) {
            U(this.f54336b, this.f54337c, i2, this.f54339e, this.f54341g, this.f54340f, this.f54342h);
        }
    }

    public void a() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(u());
        newsNotifyMessage.setMsgAtme(v());
        newsNotifyMessage.setMsgBookmark(w());
        newsNotifyMessage.setMsgChat(t());
        newsNotifyMessage.setMsgFans(y());
        newsNotifyMessage.setMsgReplyme(A());
        newsNotifyMessage.setMsgGiftNum(z());
        newsNotifyMessage.setMsgPrivateChat(this.f54343i.w());
        newsNotifyMessage.setMsgStrangerChat(this.f54343i.y());
        newsNotifyMessage.setMsgOfficialMerge(this.f54343i.t());
        T(newsNotifyMessage);
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a0(int i2) {
        if (i2 >= 0) {
            U(this.f54336b, this.f54337c, this.f54338d, this.f54339e, this.f54341g, i2, this.f54342h);
        }
    }

    public void b(d.a.n0.s.e.f fVar) {
        if (fVar == null) {
            return;
        }
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(u());
        newsNotifyMessage.setMsgAtme(v());
        newsNotifyMessage.setMsgBookmark(w());
        newsNotifyMessage.setMsgChat(((((fVar.w() + fVar.j()) + fVar.y()) + fVar.t()) + fVar.s()) - fVar.l());
        newsNotifyMessage.setMsgFans(y());
        newsNotifyMessage.setMsgReplyme(A());
        newsNotifyMessage.setMsgGiftNum(z());
        newsNotifyMessage.setMsgPrivateChat(fVar.w());
        newsNotifyMessage.setMsgStrangerChat(fVar.y());
        newsNotifyMessage.setMsgOfficialMerge(fVar.t());
        T(newsNotifyMessage);
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void b0(int i2) {
        if (i2 >= 0) {
            U(this.f54336b, this.f54337c, this.f54338d, i2, this.f54341g, this.f54340f, this.f54342h);
        }
    }

    public void c() {
        NotificationHelper.cancelNotification(this.f54335a, 16);
    }

    public void c0(int i2) {
        if (i2 >= 0) {
            U(this.f54336b, this.f54337c, this.f54338d, this.f54339e, i2, this.f54340f, this.f54342h);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            c();
            return;
        }
        d.a.n0.s.e.f F = F();
        if (F == null) {
            c();
            return;
        }
        HashMap<String, String> a2 = F.a();
        if (a2 != null && !a2.isEmpty()) {
            if (a2.containsKey(str)) {
                c();
                return;
            }
            return;
        }
        c();
    }

    public void d0(int i2) {
        if (i2 >= 0) {
            this.f54342h = i2;
        }
    }

    public void e() {
        NotificationHelper.cancelNotification(this.f54335a, 17);
    }

    public void e0(int i2) {
        if (i2 >= 0) {
            U(this.f54336b, i2, this.f54338d, this.f54339e, this.f54341g, this.f54340f, this.f54342h);
        }
    }

    public void f(int i2) {
        d.a.n0.s.e.f F = F();
        if (F == null) {
            e();
        } else if (1 == i2) {
            if (F.n() <= 0) {
                e();
            }
        } else if (2 != i2 || F.q() > 0) {
        } else {
            e();
        }
    }

    public void f0(d.a.n0.s.e.f fVar) {
        this.f54343i = fVar;
    }

    public void g() {
        NotificationHelper.cancelNotification(this.f54335a, 18);
    }

    public void h() {
        NotificationHelper.cancelNotification(this.f54335a, 23);
        NotificationHelper.cancelNotification(this.f54335a, 24);
        NotificationHelper.cancelNotification(this.f54335a, 25);
        NotificationHelper.cancelNotification(this.f54335a, 29);
        NotificationHelper.cancelNotification(this.f54335a, 26);
        NotificationHelper.cancelNotification(this.f54335a, 17);
        NotificationHelper.cancelNotification(this.f54335a, 15);
        NotificationHelper.cancelNotification(this.f54335a, 13);
        NotificationHelper.cancelNotification(this.f54335a, 12);
    }

    public final void h0(int i2, int i3) {
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    NotificationHelper.cancelNotification(this.f54335a, 16);
                    NotificationHelper.cancelNotification(this.f54335a, 17);
                }
            } else if (i3 == 23) {
                if (this.f54342h > 0) {
                    String format = String.format(this.f54335a.getString(R.string.notify_gift), String.valueOf(this.f54342h));
                    P(23, null, format, format);
                }
            } else if (i3 == 29) {
                if (this.f54336b > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format(this.f54335a.getString(R.string.notify_agree), Integer.valueOf(this.f54336b)));
                    P(29, null, sb.toString(), sb.toString());
                }
            } else if (i3 == 24) {
                if (this.f54337c > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (this.f54337c > 1) {
                        sb2.append(PreferencesUtil.LEFT_MOUNT);
                        sb2.append(String.valueOf(this.f54337c));
                        sb2.append(this.f54335a.getString(R.string.notify_unit));
                        sb2.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.m != null) {
                        sb2.append(this.m);
                    } else {
                        sb2.append(this.f54335a.getString(R.string.notify_reply));
                    }
                    P(24, null, sb2.toString(), sb2.toString());
                }
            } else if (i3 != 25) {
                if (i3 == 26) {
                    if (this.f54341g > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(this.f54335a.getString(R.string.notify_fans), Integer.valueOf(this.f54341g)));
                        P(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i3 != 16 && d.d().n()) {
                    d.d().e();
                }
            } else if (this.f54338d > 0) {
                StringBuilder sb4 = new StringBuilder();
                if (this.f54338d > 1) {
                    sb4.append(PreferencesUtil.LEFT_MOUNT);
                    sb4.append(String.valueOf(this.f54338d));
                    sb4.append(this.f54335a.getString(R.string.notify_unit));
                    sb4.append(PreferencesUtil.RIGHT_MOUNT);
                }
                if (this.n != null) {
                    sb4.append(this.n);
                } else {
                    sb4.append(this.f54335a.getString(R.string.notify_at));
                }
                P(25, null, sb4.toString(), sb4.toString());
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void i() {
        NotificationHelper.cancelNotification(this.f54335a, 29);
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x02e8 A[Catch: Exception -> 0x034a, TryCatch #0 {Exception -> 0x034a, blocks: (B:6:0x000a, B:8:0x0015, B:10:0x0019, B:14:0x003c, B:16:0x0040, B:18:0x0049, B:19:0x0063, B:21:0x0067, B:23:0x0078, B:22:0x006d, B:26:0x0089, B:28:0x008d, B:30:0x0096, B:31:0x00b0, B:33:0x00b4, B:35:0x00c5, B:34:0x00ba, B:38:0x00d6, B:40:0x00da, B:42:0x00e3, B:43:0x00fd, B:45:0x0101, B:47:0x0112, B:46:0x0107, B:50:0x0123, B:52:0x0127, B:54:0x0130, B:55:0x0149, B:58:0x0165, B:60:0x016f, B:62:0x0179, B:64:0x0184, B:66:0x018e, B:68:0x0198, B:74:0x01a6, B:76:0x01ae, B:78:0x01d8, B:80:0x01e2, B:83:0x020c, B:85:0x0212, B:87:0x0230, B:91:0x0239, B:82:0x0202, B:95:0x0246, B:97:0x024c, B:100:0x0253, B:101:0x0257, B:103:0x025d, B:105:0x0265, B:107:0x026d, B:110:0x0276, B:112:0x027c, B:114:0x0280, B:116:0x0285, B:118:0x028f, B:120:0x0299, B:122:0x02a4, B:124:0x02aa, B:126:0x02b0, B:128:0x02be, B:134:0x02e2, B:136:0x02e8, B:139:0x02f0, B:143:0x032b, B:145:0x0338, B:140:0x030c, B:129:0x02d7, B:150:0x034f), top: B:154:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x032b A[Catch: Exception -> 0x034a, TryCatch #0 {Exception -> 0x034a, blocks: (B:6:0x000a, B:8:0x0015, B:10:0x0019, B:14:0x003c, B:16:0x0040, B:18:0x0049, B:19:0x0063, B:21:0x0067, B:23:0x0078, B:22:0x006d, B:26:0x0089, B:28:0x008d, B:30:0x0096, B:31:0x00b0, B:33:0x00b4, B:35:0x00c5, B:34:0x00ba, B:38:0x00d6, B:40:0x00da, B:42:0x00e3, B:43:0x00fd, B:45:0x0101, B:47:0x0112, B:46:0x0107, B:50:0x0123, B:52:0x0127, B:54:0x0130, B:55:0x0149, B:58:0x0165, B:60:0x016f, B:62:0x0179, B:64:0x0184, B:66:0x018e, B:68:0x0198, B:74:0x01a6, B:76:0x01ae, B:78:0x01d8, B:80:0x01e2, B:83:0x020c, B:85:0x0212, B:87:0x0230, B:91:0x0239, B:82:0x0202, B:95:0x0246, B:97:0x024c, B:100:0x0253, B:101:0x0257, B:103:0x025d, B:105:0x0265, B:107:0x026d, B:110:0x0276, B:112:0x027c, B:114:0x0280, B:116:0x0285, B:118:0x028f, B:120:0x0299, B:122:0x02a4, B:124:0x02aa, B:126:0x02b0, B:128:0x02be, B:134:0x02e2, B:136:0x02e8, B:139:0x02f0, B:143:0x032b, B:145:0x0338, B:140:0x030c, B:129:0x02d7, B:150:0x034f), top: B:154:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0338 A[Catch: Exception -> 0x034a, TryCatch #0 {Exception -> 0x034a, blocks: (B:6:0x000a, B:8:0x0015, B:10:0x0019, B:14:0x003c, B:16:0x0040, B:18:0x0049, B:19:0x0063, B:21:0x0067, B:23:0x0078, B:22:0x006d, B:26:0x0089, B:28:0x008d, B:30:0x0096, B:31:0x00b0, B:33:0x00b4, B:35:0x00c5, B:34:0x00ba, B:38:0x00d6, B:40:0x00da, B:42:0x00e3, B:43:0x00fd, B:45:0x0101, B:47:0x0112, B:46:0x0107, B:50:0x0123, B:52:0x0127, B:54:0x0130, B:55:0x0149, B:58:0x0165, B:60:0x016f, B:62:0x0179, B:64:0x0184, B:66:0x018e, B:68:0x0198, B:74:0x01a6, B:76:0x01ae, B:78:0x01d8, B:80:0x01e2, B:83:0x020c, B:85:0x0212, B:87:0x0230, B:91:0x0239, B:82:0x0202, B:95:0x0246, B:97:0x024c, B:100:0x0253, B:101:0x0257, B:103:0x025d, B:105:0x0265, B:107:0x026d, B:110:0x0276, B:112:0x027c, B:114:0x0280, B:116:0x0285, B:118:0x028f, B:120:0x0299, B:122:0x02a4, B:124:0x02aa, B:126:0x02b0, B:128:0x02be, B:134:0x02e2, B:136:0x02e8, B:139:0x02f0, B:143:0x032b, B:145:0x0338, B:140:0x030c, B:129:0x02d7, B:150:0x034f), top: B:154:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(int i2, int i3, d.a.n0.s.e.f fVar) {
        boolean z;
        boolean z2;
        String e2;
        String str;
        String str2;
        String str3;
        if (fVar == null) {
            return;
        }
        boolean z3 = true;
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    NotificationHelper.cancelNotification(this.f54335a, 16);
                    NotificationHelper.cancelNotification(this.f54335a, 17);
                    return;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (i3 == 23) {
                if (this.f54342h > 0) {
                    String format = String.format(this.f54335a.getString(R.string.notify_gift), String.valueOf(this.f54342h));
                    P(23, null, format, format);
                }
            } else if (i3 == 29) {
                if (this.f54336b > 0) {
                    StringBuilder sb = new StringBuilder();
                    if (this.f54336b > 1) {
                        sb.append(PreferencesUtil.LEFT_MOUNT);
                        sb.append(String.valueOf(this.f54336b));
                        sb.append(this.f54335a.getString(R.string.notify_unit));
                        sb.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.l != null) {
                        sb.append(this.l);
                    } else {
                        sb.append(this.f54335a.getString(R.string.notify_agree));
                    }
                    P(29, null, sb.toString(), sb.toString());
                }
            } else if (i3 == 24) {
                if (this.f54337c > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (this.f54337c > 1) {
                        sb2.append(PreferencesUtil.LEFT_MOUNT);
                        sb2.append(String.valueOf(this.f54337c));
                        sb2.append(this.f54335a.getString(R.string.notify_unit));
                        sb2.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.m != null) {
                        sb2.append(this.m);
                    } else {
                        sb2.append(this.f54335a.getString(R.string.notify_reply));
                    }
                    P(24, null, sb2.toString(), sb2.toString());
                }
            } else if (i3 == 25) {
                if (this.f54338d > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    if (this.f54338d > 1) {
                        sb3.append(PreferencesUtil.LEFT_MOUNT);
                        sb3.append(String.valueOf(this.f54338d));
                        sb3.append(this.f54335a.getString(R.string.notify_unit));
                        sb3.append(PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (this.n != null) {
                        sb3.append(this.n);
                    } else {
                        sb3.append(this.f54335a.getString(R.string.notify_at));
                    }
                    P(25, null, sb3.toString(), sb3.toString());
                }
            } else if (i3 == 26) {
                if (this.f54341g > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    if (this.f54341g > 1) {
                        sb4.append(String.format(this.f54335a.getString(R.string.notify_fans_unit), Integer.valueOf(this.f54341g)));
                    }
                    sb4.append(this.f54335a.getString(R.string.notify_fans));
                    P(26, null, sb4.toString(), sb4.toString());
                }
            } else if (i3 == 16) {
                int j = (!d.d().n() || d.d().e() <= 0) ? 0 : fVar.j() - fVar.l();
                long w = (!d.d().p() || d.d().e() <= 0) ? 0L : fVar.w();
                boolean z4 = w > 0;
                long j2 = j + w;
                int i4 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
                if (i4 > 0) {
                    stringBuffer.append(String.format(this.f54335a.getString(R.string.notify_chat), Long.valueOf(j2)));
                    Q(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                } else if (i4 == 0) {
                    fVar.i();
                    fVar.f();
                    if (w == 1) {
                        String i5 = fVar.i();
                        e2 = fVar.f();
                        str2 = i5 + "：" + e2;
                        str = i5;
                    } else if (j != 1) {
                        return;
                    } else {
                        String b2 = fVar.b();
                        e2 = fVar.e();
                        str = b2;
                        str2 = e2;
                    }
                    if (TextUtils.isEmpty(e2)) {
                        stringBuffer.append(String.format(this.f54335a.getString(R.string.notify_chat), Long.valueOf(j2)));
                        str3 = stringBuffer.toString();
                    } else {
                        str3 = e2;
                    }
                    Q(16, str, str3, TextUtils.isEmpty(str2) ? str3 : str2, z4);
                }
            } else if (i3 == 19) {
                List<f.a> g2 = fVar.g();
                if (g2 != null && g2.size() != 0) {
                    for (f.a aVar : g2) {
                        if (aVar != null && !StringUtils.isNull(aVar.f54424c) && !k.isEmpty(aVar.f54422a) && aVar.f54428g > aVar.f54429h && aVar.f54430i == null) {
                            O(aVar, 19);
                        }
                    }
                }
            } else if (d.d().n() && d.d().e() > 0 && fVar.n() + fVar.q() > 0) {
                if (fVar.n() > 0 && !k0()) {
                    long n = fVar.n() - fVar.o();
                    if (n <= 0) {
                        if (fVar.o() > 0) {
                            z = false;
                            z2 = true;
                            if (fVar.q() > 0) {
                            }
                            z3 = z;
                            if (z3) {
                            }
                            if (z2) {
                            }
                        }
                    } else {
                        stringBuffer.append(String.format(this.f54335a.getString(R.string.notify_updates), Long.valueOf(n)));
                        z = true;
                        z2 = false;
                        if (fVar.q() > 0 || l0()) {
                            z3 = z;
                        } else if (!z) {
                            stringBuffer.append(String.format(this.f54335a.getString(R.string.notify_validate), Integer.valueOf(fVar.q())));
                        } else {
                            stringBuffer.append(String.format(this.f54335a.getString(R.string.notify_validate_1), Integer.valueOf(fVar.q())));
                        }
                        if (z3) {
                            P(17, null, stringBuffer.toString(), stringBuffer.toString());
                        }
                        if (z2) {
                            P(18, fVar.d(), fVar.c(), fVar.c());
                            return;
                        }
                        return;
                    }
                }
                z = false;
                z2 = false;
                if (fVar.q() > 0) {
                }
                z3 = z;
                if (z3) {
                }
                if (z2) {
                }
            }
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
        }
    }

    public void j(long j, int i2) {
        if (1 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 17, i2);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 2000, i2);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 29, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.f54335a, 26, i2);
        }
    }

    public void j0(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.m = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.l = optString3;
                }
                if (StringUtils.isNull(optString2)) {
                    return;
                }
                this.n = optString2;
            }
        }
    }

    public void k() {
        NotificationHelper.cancelNotification(this.f54335a, 25);
    }

    public final boolean k0() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void l() {
        NotificationHelper.cancelNotification(this.f54335a, 17);
        NotificationHelper.cancelNotification(this.f54335a, 19);
        NotificationHelper.cancelNotification(this.f54335a, 16);
        NotificationHelper.cancelNotification(this.f54335a, 18);
        NotificationHelper.cancelNotification(this.f54335a, 30);
    }

    public final boolean l0() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    public void m() {
        NotificationHelper.cancelNotification(this.f54335a, 26);
    }

    public void n() {
        NotificationHelper.cancelNotification(this.f54335a, 23);
    }

    public void o() {
        NotificationHelper.cancelNotification(this.f54335a, 26);
        NotificationHelper.cancelNotification(this.f54335a, 25);
        NotificationHelper.cancelNotification(this.f54335a, 24);
        NotificationHelper.cancelNotification(this.f54335a, 23);
        NotificationHelper.cancelNotification(this.f54335a, 16);
        NotificationHelper.cancelNotification(this.f54335a, 17);
        NotificationHelper.cancelNotification(this.f54335a, 29);
    }

    public void p() {
        NotificationHelper.cancelNotification(this.f54335a, 24);
    }

    public void q() {
        NotificationHelper.cancelNotification(this.f54335a, 19);
    }

    public void r(int i2) {
        NotificationHelper.cancelNotification(this.f54335a, i2);
    }

    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            c();
            return;
        }
        d.a.n0.s.e.f F = F();
        if (F == null) {
            c();
            return;
        }
        HashMap<String, String> h2 = F.h();
        if (h2 != null && !h2.isEmpty()) {
            if (h2.containsKey(str)) {
                c();
                return;
            }
            return;
        }
        c();
    }

    public int t() {
        return ((((this.f54343i.w() + this.f54343i.j()) + this.f54343i.y()) + this.f54343i.t()) + this.f54343i.s()) - this.f54343i.l();
    }

    public int u() {
        return this.f54336b;
    }

    public int v() {
        return this.f54338d;
    }

    public int w() {
        return this.f54340f;
    }

    public int x() {
        return this.f54339e;
    }

    public int y() {
        return this.f54341g;
    }

    public int z() {
        return this.f54342h;
    }
}
