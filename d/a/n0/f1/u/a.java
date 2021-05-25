package d.a.n0.f1.u;

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
import d.a.n0.f1.g.d;
import d.a.n0.f1.w.c;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f54765c = new a();

    /* renamed from: a  reason: collision with root package name */
    public HashSet<String> f54766a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f54767b = new StringBuilder();

    public static a c() {
        return f54765c;
    }

    public void a(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        StringBuilder sb = this.f54767b;
        sb.append(str);
        sb.append(",");
    }

    public void b() {
        StringBuilder sb = this.f54767b;
        if (sb != null && sb.length() > 0) {
            StringBuilder sb2 = this.f54767b;
            sb2.delete(0, sb2.length());
        }
        HashSet<String> hashSet = this.f54766a;
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
        if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (k = c.k(chatMessage.getContent())) != null && !TextUtils.isEmpty(k.f54467b) && this.f54766a.add(k.f54467b)) {
            TiebaStatic.eventStat(context, "message_open", PrefetchEvent.STATE_CLICK, 1, "task_type", k.f54466a, "task_id", k.f54467b);
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
        if (this.f54766a != null) {
            StringBuilder sb3 = new StringBuilder();
            Iterator<String> it = this.f54766a.iterator();
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
                    sb = this.f54767b;
                    if (sb != null && sb.length() > 0) {
                        this.f54767b.deleteCharAt(sb2.length() - 1);
                        str2 = this.f54767b.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        sb = this.f54767b;
        if (sb != null) {
            this.f54767b.deleteCharAt(sb2.length() - 1);
            str2 = this.f54767b.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }
}
