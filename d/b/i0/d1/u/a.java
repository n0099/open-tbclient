package d.b.i0.d1.u;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import d.b.i0.d1.g.d;
import d.b.i0.d1.w.c;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f54057c = new a();

    /* renamed from: a  reason: collision with root package name */
    public HashSet<String> f54058a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f54059b = new StringBuilder();

    public static a c() {
        return f54057c;
    }

    public void a(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        StringBuilder sb = this.f54059b;
        sb.append(str);
        sb.append(",");
    }

    public void b() {
        StringBuilder sb = this.f54059b;
        if (sb != null && sb.length() > 0) {
            StringBuilder sb2 = this.f54059b;
            sb2.delete(0, sb2.length());
        }
        HashSet<String> hashSet = this.f54058a;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public void d(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d k;
        if (chatMessage == null || StringUtils.isNull(chatMessage.getContent()) || (userInfo = chatMessage.getUserInfo()) == null) {
            return;
        }
        if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (k = c.k(chatMessage.getContent())) != null && !TextUtils.isEmpty(k.f53772b) && this.f54058a.add(k.f53772b)) {
            TiebaStatic.eventStat(context, "message_open", PrefetchEvent.STATE_CLICK, 1, "task_type", k.f53771a, "task_id", k.f53772b);
        }
    }

    public void e(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage == null || StringUtils.isNull(chatMessage.getContent()) || (userInfo = chatMessage.getUserInfo()) == null || userInfo.getUserType() != 4) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13989");
        statisticItem.param("service_id", chatMessage.getStatisticsServiceId());
        statisticItem.param("task_id", chatMessage.getStatTaskId());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public void f() {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = null;
        if (this.f54058a != null) {
            StringBuilder sb3 = new StringBuilder();
            Iterator<String> it = this.f54058a.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.length() > 0) {
                    sb3.append(next);
                    sb3.append(",");
                }
            }
            if (sb3.length() > 0) {
                sb3.deleteCharAt(sb3.length() - 1);
                if (sb3.length() > 0) {
                    str = sb3.toString();
                    sb = this.f54059b;
                    if (sb != null && sb.length() > 0) {
                        this.f54059b.deleteCharAt(sb2.length() - 1);
                        str2 = this.f54059b.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        sb = this.f54059b;
        if (sb != null) {
            this.f54059b.deleteCharAt(sb2.length() - 1);
            str2 = this.f54059b.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }
}
