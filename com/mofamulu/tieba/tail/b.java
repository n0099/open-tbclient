package com.mofamulu.tieba.tail;

import android.util.Log;
import com.mofamulu.tieba.ch.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    static b a = new b();
    ArrayList b = com.baidu.tieba.util.l.b;
    Map c = com.baidu.tieba.util.l.c;
    Map d;

    private b() {
        this.d = com.baidu.tieba.util.l.c;
        this.d = new HashMap();
        this.d.putAll(this.c);
    }

    public static b a() {
        return a;
    }

    public void b() {
        if (bg.c().E()) {
            b(c());
        }
    }

    private void b(LinkedList linkedList) {
        String str;
        bg c = bg.c();
        if (c.e(false) && c.x().a.optInt(bg.a(), 0) == 0) {
            com.mofamulu.tieba.ch.a.a = 63;
            com.mofamulu.tieba.ch.a.a();
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : com.baidu.tieba.util.l.d.entrySet()) {
            hashMap.put((String) entry.getValue(), (String) entry.getKey());
        }
        for (Map.Entry entry2 : this.d.entrySet()) {
            hashMap.remove(((String) entry2.getKey()).substring(2, str.length() - 1));
        }
        boolean d = c.x().d();
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            c cVar = (c) linkedList.get(i);
            if (cVar.c && (!cVar.b || d)) {
                String[] strArr = cVar.d;
                for (String str2 : strArr) {
                    linkedList2.addLast(str2);
                }
            }
        }
        this.b.clear();
        this.c.clear();
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            String str4 = "#(" + str3 + ")";
            if (!this.c.containsKey(str4)) {
                Integer num = (Integer) this.d.get(str4);
                if (num != null) {
                    this.b.add(num);
                    this.c.put(str4, num);
                } else {
                    String str5 = (String) hashMap.get(str3);
                    if (str5 != null) {
                        Integer num2 = (Integer) com.baidu.tieba.util.l.a.get(str5);
                        if (num2 != null) {
                            this.b.add(num2);
                            this.c.put(str4, num2);
                        } else {
                            Log.e("tbhp_em", "no resId for em text:" + str3);
                        }
                    } else {
                        Log.e("tbhp_em", "no fileName for em text:" + str3);
                    }
                }
            }
        }
    }

    public LinkedList c() {
        String[] d;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new c("泡泡", false, "呵呵@哈哈@吐舌@啊@酷@怒@开心@汗@泪@黑线@鄙视@不高兴@真棒@钱@疑问@阴险@吐@咦@委屈@花心@呼~@笑眼@冷@太开心@滑稽@勉强@狂汗@乖@睡觉@惊哭@升起@惊讶@喷"));
        linkedList.add(new c("泡泡心", false, "爱心@心碎@玫瑰@礼物@彩虹@星星月亮@太阳@钱币@灯泡@茶杯@蛋糕@音乐@haha@胜利@大拇指@弱@OK"));
        linkedList.add(new c("阿狸", false, "哭着跑@惆怅~@摸头@蹭@打滚@叩拜@摸@数钱@加1@压力@表逼我@人呢@摇晃@打地鼠@这个屌@恐慌@晕乎乎@浮云@给力@杯具了"));
        linkedList.add(new c("影子", false, "焦糖舞@翻滚@拍屁股做鬼脸@不@河蟹掉啦@哦耶@我倒@投降@听音乐@被砸@吐舌头@太好啦@财源滚滚@人去哪了@偷笑@卷被@看楼上@我抽@有木有@哭"));
        linkedList.add(new c("气泡熊", false, "微笑@帅哥@美女@老大@哈哈哈@奸笑@傻乐@飞吻@害羞@花痴@憧憬@你牛@鼓掌@可爱@太委屈@大哭@泪奔@寻死@非常惊讶@表示疑问"));
        linkedList.add(new c("阿狸1", true, "郁闷@飘过@赖皮@感动@十分惊讶@怒气@哭泣@吃惊@嘲弄@数钱"));
        linkedList.add(new c("阿狸2", true, "转圈哭@神经病@揪耳朵@惊汗@隐身@不要@遁@不公平@爬来了@蛋花哭"));
        linkedList.add(new c("阿狸3", true, "温暖@点头@撒钱@献花@寒@傻笑@扭扭@疯@抓狂@抓"));
        linkedList.add(new c("阿狸4", true, "蜷@挠墙@狂笑@抱枕@吼叫@嚷@唠叨@捏脸@爆笑@郁闷"));
        linkedList.add(new c("阿狸5", true, "潜水@十分开心@冷笑话@顶@潜@画圈圈@玩电脑@狂吐@阿狸侠@冷死了"));
        linkedList.add(new c("阿狸6", true, "拖走@热@不要@顶@抓狂@隆重介绍"));
        linkedList.add(new c("新年表情", true, "蛇年@红包拿来@美人鱼@恭喜发财@回家过年@点灯笼@招财兔@喜庆鼓@扭一扭@又长一岁@年年有鱼@求红包@压岁钱@拜年"));
        linkedList.add(new c("气泡熊1", true, "你牛@鄙视你@大骂@狂怒@囧@晕@呕吐@财迷@睡了@思考"));
        linkedList.add(new c("气泡熊2", true, "真汗@无语@拜@鞠躬@累了@病了@墙角@超人@戳@跳舞"));
        linkedList.add(new c("气泡熊3", true, "鬼脸@无聊@撞墙@顶起@HI@饭@生日蛋糕@精美礼物@心@我心碎"));
        linkedList.add(new c("气泡熊4", true, "玫瑰花@炸弹@集体舞@打人@拍拍@亲亲@握手@布@石头@剪子@安慰@恭喜啦@啵啵"));
        linkedList.add(new c("影子1", true, "哦耶@挥手帕@欢呼@傻兮兮@扇扇子@拍手@紧张@洗澡@耶@吃西瓜"));
        linkedList.add(new c("影子2", true, "纳尼@没有钱@拿玩偶@来看看@哇哇叫@招财猫@放屁@求你了@撞玻璃@眺望"));
        linkedList.add(new c("影子3", true, "撒花@玩铃铛@思考者@抽风@吃苹果@光棍"));
        LinkedList linkedList2 = new LinkedList();
        for (String str : d()) {
            int i = 0;
            while (true) {
                if (i >= linkedList.size()) {
                    break;
                }
                c cVar = (c) linkedList.get(i);
                if (!str.equalsIgnoreCase(cVar.a)) {
                    i++;
                } else {
                    cVar.c = true;
                    linkedList.remove(cVar);
                    linkedList2.add(cVar);
                    break;
                }
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((c) it.next());
        }
        return linkedList2;
    }

    public String[] d() {
        String F = bg.c().F();
        if (F == null) {
            F = "泡泡,泡泡心,阿狸,影子,气泡熊";
        }
        return F.split(",");
    }

    public void a(LinkedList linkedList) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < linkedList.size(); i++) {
            c cVar = (c) linkedList.get(i);
            if (cVar.c) {
                if (z) {
                    sb.append(",");
                } else {
                    z = true;
                }
                sb.append(cVar.a);
            }
        }
        bg.c().d(sb.toString());
        b(linkedList);
    }
}
