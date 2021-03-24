package d.b.h0.s.d;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import d.b.b.e.p.k;
import d.b.h0.s.e.f;
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
/* loaded from: classes.dex */
public class b {
    public static b o;
    public static Date p;
    public static Handler q = new a();
    public d.b.h0.s.e.f j;
    public String l;
    public String m;
    public String n;

    /* renamed from: b  reason: collision with root package name */
    public int f51251b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f51252c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51253d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f51254e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51255f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f51256g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f51257h = 0;
    public d.b.h0.s.e.f i = new d.b.h0.s.e.f();
    public boolean k = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f51250a = TbadkCoreApplication.getInst().getApp();

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
            int i = (calendar.get(11) * 60) + calendar.get(12);
            String[] split = d.d().g().split(":");
            int parseInt = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
            String[] split2 = d.d().f().split(":");
            int parseInt2 = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
            if (parseInt < parseInt2) {
                if (i < parseInt || i > parseInt2) {
                    return false;
                }
            } else if (parseInt <= parseInt2) {
                return false;
            } else {
                if ((i < parseInt || i > 1439) && (i < 0 || i > parseInt2)) {
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
        return this.f51252c;
    }

    public d.b.h0.s.e.f B() {
        return this.j;
    }

    public int C(int i) {
        if (i == 12 || i == 13 || i == 28) {
            return 2;
        }
        if (i != 29) {
            if (i != 2000) {
                switch (i) {
                    case 15:
                    case 18:
                    case 19:
                        return 2;
                    case 16:
                    case 17:
                        return 1;
                    default:
                        switch (i) {
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
        return this.f51251b + this.f51252c + this.f51253d + this.f51254e + this.f51256g + this.f51257h;
    }

    public d.b.h0.s.e.f F() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent G(int i, boolean z) {
        String str;
        if (z) {
            Set<String> keySet = this.i.h().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
                Intent intent = new Intent();
                if (!UtilHelper.isFlyMeOs()) {
                    intent.setClass(this.f51250a, DealIntentActivity.class);
                } else {
                    intent.setClass(this.f51250a, DealIntentService.class);
                }
                intent.putExtra(DealIntentService.KEY_CLASS, 5);
                intent.putExtra("KeyOfNotiId", i);
                intent.putExtra("agree_me", this.f51251b);
                intent.putExtra("at_me", this.f51253d);
                intent.putExtra("reply_me", this.f51252c);
                intent.putExtra("fans", this.f51256g);
                intent.putExtra("chat", x());
                intent.putExtra("group_msg", this.i.j() - this.i.l());
                intent.putExtra("group_msg_validate", this.i.q());
                intent.putExtra("group_msg_updates", this.i.n());
                intent.putExtra("officialbar_msg", this.i.u());
                intent.putExtra("privateGid", str);
                return intent;
            }
        }
        str = "";
        Intent intent2 = new Intent();
        if (!UtilHelper.isFlyMeOs()) {
        }
        intent2.putExtra(DealIntentService.KEY_CLASS, 5);
        intent2.putExtra("KeyOfNotiId", i);
        intent2.putExtra("agree_me", this.f51251b);
        intent2.putExtra("at_me", this.f51253d);
        intent2.putExtra("reply_me", this.f51252c);
        intent2.putExtra("fans", this.f51256g);
        intent2.putExtra("chat", x());
        intent2.putExtra("group_msg", this.i.j() - this.i.l());
        intent2.putExtra("group_msg_validate", this.i.q());
        intent2.putExtra("group_msg_updates", this.i.n());
        intent2.putExtra("officialbar_msg", this.i.u());
        intent2.putExtra("privateGid", str);
        return intent2;
    }

    public Intent H(f.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f51250a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f51250a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 36);
        intent.putExtra("tab_id", 1);
        return intent;
    }

    public Intent I(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f51250a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f51250a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.f51257h);
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
            intent.setClass(this.f51250a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f51250a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 27);
        intent.putExtra("uid", aVar.f51331a);
        intent.putExtra("uname", aVar.f51335e);
        intent.putExtra("user_type", aVar.f51336f);
        return intent;
    }

    public Intent K(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.f51250a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f51250a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 35);
        intent.putExtra("KeyOfNotiId", i);
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
            intent.setClass(this.f51250a, DealIntentActivity.class);
        } else {
            intent.setClass(this.f51250a, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.i.o());
        return intent;
    }

    public boolean N(String str) {
        return "3222425470".equals(str);
    }

    public final void O(f.a aVar, int i) {
        PendingIntent service;
        Intent S = S(aVar);
        if (S != null && S.getDataString() != null && S.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            S.setFlags(276824064);
            NotificationHelper.showNotification(this.f51250a, i, aVar.f51332b, aVar.f51333c, aVar.f51334d, PendingIntent.getActivity(this.f51250a, i, S, 134217728), false);
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
            service = PendingIntent.getActivity(this.f51250a, i, S, 134217728);
        } else {
            service = PendingIntent.getService(this.f51250a, i, S, 134217728);
        }
        j(C(i), i);
        NotificationHelper.showNotification(this.f51250a, i, aVar.f51332b, aVar.f51333c, aVar.f51334d, service, false);
    }

    public final void P(int i, String str, String str2, String str3) {
        Q(i, str, str2, str3, false);
    }

    public final void Q(int i, String str, String str2, String str3, boolean z) {
        Intent G;
        PendingIntent service;
        if (this.k) {
            if (i == 23 && this.f51257h > 0) {
                G = I(i);
            } else if (i == 26 && this.f51256g > 0) {
                G = K(i);
            } else if (i == 18) {
                G = L();
            } else if (i == 24) {
                G = G(i, z);
                G.putExtra("tab_id", 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i != 16 && i != 17 && i != 18) {
                G = G(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                G = G(i, z);
                G.putExtra("tab_id", 2);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            G.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.f51250a, i, G, 134217728);
            } else {
                service = PendingIntent.getService(this.f51250a, i, G, 134217728);
            }
            j(C(i), i);
            NotificationHelper.showNotification(this.f51250a, i, str, str2, str3, service, false);
        }
    }

    public Intent S(f.a aVar) {
        ImMessageCenterPojo i;
        if (aVar != null && (i = d.b.i0.d1.k.b.o().i(aVar.f51331a, aVar.f51336f)) != null && i.getLast_content() != null) {
            try {
                String lastTaskId = i.getLastTaskId();
                String lastServiceId = i.getLastServiceId();
                JSONArray jSONArray = new JSONArray(i.getLastContentRawData());
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
                            intent.setClass(this.f51250a, DealIntentActivity.class);
                        } else {
                            intent.setClass(this.f51250a, DealIntentService.class);
                        }
                        intent.putExtra(DealIntentService.KEY_CLASS, 1);
                        intent.putExtra("id", group);
                        intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
                        intent.putExtra("key_start_from", 7);
                        intent.putExtra("gid", aVar.f51331a);
                        intent.putExtra("task_id", lastTaskId);
                        intent.putExtra("service_id", lastServiceId);
                        return intent;
                    }
                } else {
                    if (!optString.contains("mo/q/hotMessage") && !optString.contains("mo/q/newtopic")) {
                        if (optString.contains("open_wb_view=1")) {
                            Intent intent2 = new Intent();
                            if (UtilHelper.isFlyMeOs()) {
                                intent2.setClass(this.f51250a, DealIntentActivity.class);
                            } else {
                                intent2.setClass(this.f51250a, DealIntentService.class);
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
                                    intent3.setClass(this.f51250a, DealIntentActivity.class);
                                } else {
                                    intent3.setClass(this.f51250a, DealIntentService.class);
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
                        intent4.setClass(this.f51250a, DealIntentActivity.class);
                    } else {
                        intent4.setClass(this.f51250a, DealIntentService.class);
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

    public void U(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        if (i == this.f51251b && i2 == this.f51252c && i3 == this.f51253d && i4 == this.f51254e && i5 == this.f51256g && i6 == this.f51255f && i7 == this.f51257h) {
            return;
        }
        int i13 = this.f51251b;
        int i14 = 2;
        int i15 = (i > i13 || i2 > (i11 = this.f51252c) || i3 > (i12 = this.f51253d) || i4 > this.f51254e || i5 > this.f51256g || i6 > this.f51255f || i7 > this.f51257h) ? 1 : (i < i13 || i2 < i11 || i3 < i12) ? 2 : 0;
        if (i <= this.f51251b || !d.d().w()) {
            i8 = i < this.f51251b ? 2 : 0;
        } else {
            i8 = 1;
        }
        if (i2 <= this.f51252c || !d.d().t()) {
            i9 = i2 < this.f51252c ? 2 : 0;
        } else {
            i9 = 1;
        }
        if (i3 <= this.f51253d || !d.d().o()) {
            i10 = i3 < this.f51253d ? 2 : 0;
        } else {
            i10 = 1;
        }
        int i16 = i4 > this.f51254e ? 1 : 0;
        int i17 = i5 > this.f51256g ? 1 : 0;
        int i18 = i7 > this.f51257h ? 1 : 0;
        this.f51251b = i;
        this.f51252c = i2;
        this.f51253d = i3;
        this.f51254e = i4;
        this.f51256g = i5;
        this.f51255f = i6;
        this.f51257h = i7;
        if (E() <= 0) {
            i15 = 2;
            i17 = 2;
            i8 = 2;
            i9 = 2;
            i10 = 2;
            i16 = 2;
        } else {
            i14 = i18;
        }
        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
            return;
        }
        a();
        h0(i14, 23);
        h0(i16, 16);
        h0(i15, 17);
        h0(i9, 24);
        h0(i10, 25);
        h0(i17, 26);
        h0(i8, 29);
    }

    public void V(d.b.h0.s.e.f fVar) {
        if (fVar == null) {
            return;
        }
        this.i = fVar;
        this.f51254e = (fVar.j() - fVar.l()) + fVar.w() + fVar.t() + fVar.s();
        b(fVar);
        int i = 0;
        if (fVar.z()) {
            this.j = null;
            q.removeMessages(0);
        }
        if (fVar.z()) {
            if (d.d().n() && d.d().e() > 0) {
                i = fVar.j() - fVar.l();
            }
            long w = (!d.d().p() || d.d().e() <= 0) ? 0L : fVar.w();
            if ((i > 0 || w > 0) && ((i > fVar.m() - fVar.l() && i > 0) || w > fVar.x())) {
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

    public void W(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i == this.f51251b && i2 == this.f51252c && i3 == this.f51253d && i4 == this.f51254e && i5 == this.f51256g && this.f51257h == i6) {
            return;
        }
        this.f51251b = i;
        this.f51252c = i2;
        this.f51253d = i3;
        this.f51254e = i4;
        this.f51256g = i5;
        this.f51257h = i6;
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
        this.f51251b = 0;
        this.f51252c = 0;
        this.f51253d = 0;
        this.f51254e = 0;
        this.f51256g = 0;
        this.f51255f = 0;
    }

    public void Y(int i) {
        if (i >= 0) {
            U(i, this.f51252c, this.f51253d, this.f51254e, this.f51256g, this.f51255f, this.f51257h);
        }
    }

    public void Z(int i) {
        if (i >= 0) {
            U(this.f51251b, this.f51252c, i, this.f51254e, this.f51256g, this.f51255f, this.f51257h);
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
        newsNotifyMessage.setMsgPrivateChat(this.i.w());
        newsNotifyMessage.setMsgStrangerChat(this.i.y());
        newsNotifyMessage.setMsgOfficialMerge(this.i.t());
        T(newsNotifyMessage);
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a0(int i) {
        if (i >= 0) {
            U(this.f51251b, this.f51252c, this.f51253d, this.f51254e, this.f51256g, i, this.f51257h);
        }
    }

    public void b(d.b.h0.s.e.f fVar) {
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

    public void b0(int i) {
        if (i >= 0) {
            U(this.f51251b, this.f51252c, this.f51253d, i, this.f51256g, this.f51255f, this.f51257h);
        }
    }

    public void c() {
        NotificationHelper.cancelNotification(this.f51250a, 16);
    }

    public void c0(int i) {
        if (i >= 0) {
            U(this.f51251b, this.f51252c, this.f51253d, this.f51254e, i, this.f51255f, this.f51257h);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            c();
            return;
        }
        d.b.h0.s.e.f F = F();
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

    public void d0(int i) {
        if (i >= 0) {
            this.f51257h = i;
        }
    }

    public void e() {
        NotificationHelper.cancelNotification(this.f51250a, 17);
    }

    public void e0(int i) {
        if (i >= 0) {
            U(this.f51251b, i, this.f51253d, this.f51254e, this.f51256g, this.f51255f, this.f51257h);
        }
    }

    public void f(int i) {
        d.b.h0.s.e.f F = F();
        if (F == null) {
            e();
        } else if (1 == i) {
            if (F.n() <= 0) {
                e();
            }
        } else if (2 != i || F.q() > 0) {
        } else {
            e();
        }
    }

    public void f0(d.b.h0.s.e.f fVar) {
        this.i = fVar;
    }

    public void g() {
        NotificationHelper.cancelNotification(this.f51250a, 18);
    }

    public void h() {
        NotificationHelper.cancelNotification(this.f51250a, 23);
        NotificationHelper.cancelNotification(this.f51250a, 24);
        NotificationHelper.cancelNotification(this.f51250a, 25);
        NotificationHelper.cancelNotification(this.f51250a, 29);
        NotificationHelper.cancelNotification(this.f51250a, 26);
        NotificationHelper.cancelNotification(this.f51250a, 17);
        NotificationHelper.cancelNotification(this.f51250a, 15);
        NotificationHelper.cancelNotification(this.f51250a, 13);
        NotificationHelper.cancelNotification(this.f51250a, 12);
    }

    public final void h0(int i, int i2) {
        try {
            if (i != 1) {
                if (i == 2) {
                    NotificationHelper.cancelNotification(this.f51250a, 16);
                    NotificationHelper.cancelNotification(this.f51250a, 17);
                }
            } else if (i2 == 23) {
                if (this.f51257h > 0) {
                    String format = String.format(this.f51250a.getString(R.string.notify_gift), String.valueOf(this.f51257h));
                    P(23, null, format, format);
                }
            } else if (i2 == 29) {
                if (this.f51251b > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format(this.f51250a.getString(R.string.notify_agree), Integer.valueOf(this.f51251b)));
                    P(29, null, sb.toString(), sb.toString());
                }
            } else if (i2 == 24) {
                if (this.f51252c > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (this.f51252c > 1) {
                        sb2.append("[");
                        sb2.append(String.valueOf(this.f51252c));
                        sb2.append(this.f51250a.getString(R.string.notify_unit));
                        sb2.append("]");
                    }
                    if (this.m != null) {
                        sb2.append(this.m);
                    } else {
                        sb2.append(this.f51250a.getString(R.string.notify_reply));
                    }
                    P(24, null, sb2.toString(), sb2.toString());
                }
            } else if (i2 != 25) {
                if (i2 == 26) {
                    if (this.f51256g > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(this.f51250a.getString(R.string.notify_fans), Integer.valueOf(this.f51256g)));
                        P(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && d.d().n()) {
                    d.d().e();
                }
            } else if (this.f51253d > 0) {
                StringBuilder sb4 = new StringBuilder();
                if (this.f51253d > 1) {
                    sb4.append("[");
                    sb4.append(String.valueOf(this.f51253d));
                    sb4.append(this.f51250a.getString(R.string.notify_unit));
                    sb4.append("]");
                }
                if (this.n != null) {
                    sb4.append(this.n);
                } else {
                    sb4.append(this.f51250a.getString(R.string.notify_at));
                }
                P(25, null, sb4.toString(), sb4.toString());
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void i() {
        NotificationHelper.cancelNotification(this.f51250a, 29);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x02eb A[Catch: Exception -> 0x034d, TryCatch #0 {Exception -> 0x034d, blocks: (B:6:0x000a, B:8:0x0015, B:10:0x0019, B:14:0x003c, B:16:0x0040, B:18:0x0049, B:19:0x0063, B:21:0x0067, B:23:0x0078, B:22:0x006d, B:26:0x0089, B:28:0x008d, B:30:0x0096, B:31:0x00b0, B:33:0x00b4, B:35:0x00c5, B:34:0x00ba, B:38:0x00d6, B:40:0x00da, B:42:0x00e3, B:43:0x00fd, B:45:0x0101, B:47:0x0112, B:46:0x0107, B:50:0x0123, B:52:0x0127, B:54:0x0130, B:55:0x0149, B:58:0x0165, B:60:0x016f, B:62:0x0179, B:64:0x0184, B:66:0x018e, B:68:0x0198, B:74:0x01a6, B:76:0x01ae, B:79:0x01da, B:81:0x01e4, B:84:0x020f, B:86:0x0215, B:88:0x0233, B:92:0x023c, B:83:0x0205, B:96:0x0249, B:98:0x024f, B:101:0x0256, B:102:0x025a, B:104:0x0260, B:106:0x0268, B:108:0x0270, B:111:0x0279, B:113:0x027f, B:115:0x0283, B:117:0x0288, B:119:0x0292, B:121:0x029c, B:123:0x02a7, B:125:0x02ad, B:127:0x02b3, B:129:0x02c1, B:135:0x02e5, B:137:0x02eb, B:140:0x02f3, B:144:0x032e, B:146:0x033b, B:141:0x030f, B:130:0x02da, B:151:0x0352), top: B:155:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x032e A[Catch: Exception -> 0x034d, TryCatch #0 {Exception -> 0x034d, blocks: (B:6:0x000a, B:8:0x0015, B:10:0x0019, B:14:0x003c, B:16:0x0040, B:18:0x0049, B:19:0x0063, B:21:0x0067, B:23:0x0078, B:22:0x006d, B:26:0x0089, B:28:0x008d, B:30:0x0096, B:31:0x00b0, B:33:0x00b4, B:35:0x00c5, B:34:0x00ba, B:38:0x00d6, B:40:0x00da, B:42:0x00e3, B:43:0x00fd, B:45:0x0101, B:47:0x0112, B:46:0x0107, B:50:0x0123, B:52:0x0127, B:54:0x0130, B:55:0x0149, B:58:0x0165, B:60:0x016f, B:62:0x0179, B:64:0x0184, B:66:0x018e, B:68:0x0198, B:74:0x01a6, B:76:0x01ae, B:79:0x01da, B:81:0x01e4, B:84:0x020f, B:86:0x0215, B:88:0x0233, B:92:0x023c, B:83:0x0205, B:96:0x0249, B:98:0x024f, B:101:0x0256, B:102:0x025a, B:104:0x0260, B:106:0x0268, B:108:0x0270, B:111:0x0279, B:113:0x027f, B:115:0x0283, B:117:0x0288, B:119:0x0292, B:121:0x029c, B:123:0x02a7, B:125:0x02ad, B:127:0x02b3, B:129:0x02c1, B:135:0x02e5, B:137:0x02eb, B:140:0x02f3, B:144:0x032e, B:146:0x033b, B:141:0x030f, B:130:0x02da, B:151:0x0352), top: B:155:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x033b A[Catch: Exception -> 0x034d, TryCatch #0 {Exception -> 0x034d, blocks: (B:6:0x000a, B:8:0x0015, B:10:0x0019, B:14:0x003c, B:16:0x0040, B:18:0x0049, B:19:0x0063, B:21:0x0067, B:23:0x0078, B:22:0x006d, B:26:0x0089, B:28:0x008d, B:30:0x0096, B:31:0x00b0, B:33:0x00b4, B:35:0x00c5, B:34:0x00ba, B:38:0x00d6, B:40:0x00da, B:42:0x00e3, B:43:0x00fd, B:45:0x0101, B:47:0x0112, B:46:0x0107, B:50:0x0123, B:52:0x0127, B:54:0x0130, B:55:0x0149, B:58:0x0165, B:60:0x016f, B:62:0x0179, B:64:0x0184, B:66:0x018e, B:68:0x0198, B:74:0x01a6, B:76:0x01ae, B:79:0x01da, B:81:0x01e4, B:84:0x020f, B:86:0x0215, B:88:0x0233, B:92:0x023c, B:83:0x0205, B:96:0x0249, B:98:0x024f, B:101:0x0256, B:102:0x025a, B:104:0x0260, B:106:0x0268, B:108:0x0270, B:111:0x0279, B:113:0x027f, B:115:0x0283, B:117:0x0288, B:119:0x0292, B:121:0x029c, B:123:0x02a7, B:125:0x02ad, B:127:0x02b3, B:129:0x02c1, B:135:0x02e5, B:137:0x02eb, B:140:0x02f3, B:144:0x032e, B:146:0x033b, B:141:0x030f, B:130:0x02da, B:151:0x0352), top: B:155:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(int i, int i2, d.b.h0.s.e.f fVar) {
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
            if (i != 1) {
                if (i == 2) {
                    NotificationHelper.cancelNotification(this.f51250a, 16);
                    NotificationHelper.cancelNotification(this.f51250a, 17);
                    return;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (i2 == 23) {
                if (this.f51257h > 0) {
                    String format = String.format(this.f51250a.getString(R.string.notify_gift), String.valueOf(this.f51257h));
                    P(23, null, format, format);
                }
            } else if (i2 == 29) {
                if (this.f51251b > 0) {
                    StringBuilder sb = new StringBuilder();
                    if (this.f51251b > 1) {
                        sb.append("[");
                        sb.append(String.valueOf(this.f51251b));
                        sb.append(this.f51250a.getString(R.string.notify_unit));
                        sb.append("]");
                    }
                    if (this.l != null) {
                        sb.append(this.l);
                    } else {
                        sb.append(this.f51250a.getString(R.string.notify_agree));
                    }
                    P(29, null, sb.toString(), sb.toString());
                }
            } else if (i2 == 24) {
                if (this.f51252c > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (this.f51252c > 1) {
                        sb2.append("[");
                        sb2.append(String.valueOf(this.f51252c));
                        sb2.append(this.f51250a.getString(R.string.notify_unit));
                        sb2.append("]");
                    }
                    if (this.m != null) {
                        sb2.append(this.m);
                    } else {
                        sb2.append(this.f51250a.getString(R.string.notify_reply));
                    }
                    P(24, null, sb2.toString(), sb2.toString());
                }
            } else if (i2 == 25) {
                if (this.f51253d > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    if (this.f51253d > 1) {
                        sb3.append("[");
                        sb3.append(String.valueOf(this.f51253d));
                        sb3.append(this.f51250a.getString(R.string.notify_unit));
                        sb3.append("]");
                    }
                    if (this.n != null) {
                        sb3.append(this.n);
                    } else {
                        sb3.append(this.f51250a.getString(R.string.notify_at));
                    }
                    P(25, null, sb3.toString(), sb3.toString());
                }
            } else if (i2 == 26) {
                if (this.f51256g > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    if (this.f51256g > 1) {
                        sb4.append(String.format(this.f51250a.getString(R.string.notify_fans_unit), Integer.valueOf(this.f51256g)));
                    }
                    sb4.append(this.f51250a.getString(R.string.notify_fans));
                    P(26, null, sb4.toString(), sb4.toString());
                }
            } else if (i2 == 16) {
                int j = (!d.d().n() || d.d().e() <= 0) ? 0 : fVar.j() - fVar.l();
                long w = (!d.d().p() || d.d().e() <= 0) ? 0L : fVar.w();
                boolean z4 = w > 0;
                long j2 = j + w;
                if (j2 > 1) {
                    stringBuffer.append(String.format(this.f51250a.getString(R.string.notify_chat), Long.valueOf(j2)));
                    Q(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                } else if (j2 == 1) {
                    fVar.i();
                    fVar.f();
                    if (w == 1) {
                        String i3 = fVar.i();
                        e2 = fVar.f();
                        str2 = i3 + "：" + e2;
                        str = i3;
                    } else if (j != 1) {
                        return;
                    } else {
                        String b2 = fVar.b();
                        e2 = fVar.e();
                        str = b2;
                        str2 = e2;
                    }
                    if (TextUtils.isEmpty(e2)) {
                        stringBuffer.append(String.format(this.f51250a.getString(R.string.notify_chat), Long.valueOf(j2)));
                        str3 = stringBuffer.toString();
                    } else {
                        str3 = e2;
                    }
                    Q(16, str, str3, TextUtils.isEmpty(str2) ? str3 : str2, z4);
                }
            } else if (i2 == 19) {
                List<f.a> g2 = fVar.g();
                if (g2 != null && g2.size() != 0) {
                    for (f.a aVar : g2) {
                        if (aVar != null && !StringUtils.isNull(aVar.f51333c) && !k.isEmpty(aVar.f51331a) && aVar.f51337g > aVar.f51338h && aVar.i == null) {
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
                        stringBuffer.append(String.format(this.f51250a.getString(R.string.notify_updates), Long.valueOf(n)));
                        z = true;
                        z2 = false;
                        if (fVar.q() > 0 || l0()) {
                            z3 = z;
                        } else if (!z) {
                            stringBuffer.append(String.format(this.f51250a.getString(R.string.notify_validate), Integer.valueOf(fVar.q())));
                        } else {
                            stringBuffer.append(String.format(this.f51250a.getString(R.string.notify_validate_1), Integer.valueOf(fVar.q())));
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

    public void j(long j, int i) {
        if (1 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.f51250a, 26, i);
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
        NotificationHelper.cancelNotification(this.f51250a, 25);
    }

    public final boolean k0() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void l() {
        NotificationHelper.cancelNotification(this.f51250a, 17);
        NotificationHelper.cancelNotification(this.f51250a, 19);
        NotificationHelper.cancelNotification(this.f51250a, 16);
        NotificationHelper.cancelNotification(this.f51250a, 18);
        NotificationHelper.cancelNotification(this.f51250a, 30);
    }

    public final boolean l0() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    public void m() {
        NotificationHelper.cancelNotification(this.f51250a, 26);
    }

    public void n() {
        NotificationHelper.cancelNotification(this.f51250a, 23);
    }

    public void o() {
        NotificationHelper.cancelNotification(this.f51250a, 26);
        NotificationHelper.cancelNotification(this.f51250a, 25);
        NotificationHelper.cancelNotification(this.f51250a, 24);
        NotificationHelper.cancelNotification(this.f51250a, 23);
        NotificationHelper.cancelNotification(this.f51250a, 16);
        NotificationHelper.cancelNotification(this.f51250a, 17);
        NotificationHelper.cancelNotification(this.f51250a, 29);
    }

    public void p() {
        NotificationHelper.cancelNotification(this.f51250a, 24);
    }

    public void q() {
        NotificationHelper.cancelNotification(this.f51250a, 19);
    }

    public void r(int i) {
        NotificationHelper.cancelNotification(this.f51250a, i);
    }

    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            c();
            return;
        }
        d.b.h0.s.e.f F = F();
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
        return ((((this.i.w() + this.i.j()) + this.i.y()) + this.i.t()) + this.i.s()) - this.i.l();
    }

    public int u() {
        return this.f51251b;
    }

    public int v() {
        return this.f51253d;
    }

    public int w() {
        return this.f51255f;
    }

    public int x() {
        return this.f51254e;
    }

    public int y() {
        return this.f51256g;
    }

    public int z() {
        return this.f51257h;
    }
}
