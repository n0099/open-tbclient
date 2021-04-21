package d.b.i0.w.p;

import android.content.Context;
import com.baidu.tieba.R;
import d.b.i0.a0.a;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements d.b.i0.a0.a {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f52292a = new HashMap<>(200);

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<Integer> f52293b = new ArrayList<>(180);

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f52294c = new HashMap<>(180);

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, String> f52295d;

    static {
        HashMap<String, String> hashMap = new HashMap<>(180);
        f52295d = hashMap;
        hashMap.put("image_emoticon", "呵呵");
        f52295d.put("image_emoticon2", "哈哈");
        f52295d.put("image_emoticon3", "吐舌");
        f52295d.put("image_emoticon4", "啊");
        f52295d.put("image_emoticon5", "酷");
        f52295d.put("image_emoticon6", "怒");
        f52295d.put("image_emoticon7", "开心");
        f52295d.put("image_emoticon8", "汗");
        f52295d.put("image_emoticon9", "泪");
        f52295d.put("image_emoticon10", "黑线");
        f52295d.put("image_emoticon11", "鄙视");
        f52295d.put("image_emoticon12", "不高兴");
        f52295d.put("image_emoticon13", "真棒");
        f52295d.put("image_emoticon14", "钱");
        f52295d.put("image_emoticon15", "疑问");
        f52295d.put("image_emoticon16", "阴险");
        f52295d.put("image_emoticon17", "吐");
        f52295d.put("image_emoticon18", "咦");
        f52295d.put("image_emoticon19", "委屈");
        f52295d.put("image_emoticon20", "花心");
        f52295d.put("image_emoticon21", "呼~");
        f52295d.put("image_emoticon22", "笑眼");
        f52295d.put("image_emoticon23", "冷");
        f52295d.put("image_emoticon24", "太开心");
        f52295d.put("image_emoticon25", "滑稽");
        f52295d.put("image_emoticon26", "勉强");
        f52295d.put("image_emoticon27", "狂汗");
        f52295d.put("image_emoticon28", "乖");
        f52295d.put("image_emoticon29", "睡觉");
        f52295d.put("image_emoticon30", "惊哭");
        f52295d.put("image_emoticon31", "生气");
        f52295d.put("image_emoticon32", "惊讶");
        f52295d.put("image_emoticon33", "喷");
        f52295d.put("image_emoticon34", "爱心");
        f52295d.put("image_emoticon35", "心碎");
        f52295d.put("image_emoticon36", "玫瑰");
        f52295d.put("image_emoticon37", "礼物");
        f52295d.put("image_emoticon38", "彩虹");
        f52295d.put("image_emoticon39", "星星月亮");
        f52295d.put("image_emoticon40", "太阳");
        f52295d.put("image_emoticon41", "钱币");
        f52295d.put("image_emoticon42", "灯泡");
        f52295d.put("image_emoticon43", "茶杯");
        f52295d.put("image_emoticon44", "蛋糕");
        f52295d.put("image_emoticon45", "音乐");
        f52295d.put("image_emoticon46", "haha");
        f52295d.put("image_emoticon47", "胜利");
        f52295d.put("image_emoticon48", "大拇指");
        f52295d.put("image_emoticon49", "弱");
        f52295d.put("image_emoticon50", "OK");
        f52295d.put("image_emoticon61", "哼");
        f52295d.put("image_emoticon62", "吃瓜");
        f52295d.put("image_emoticon63", "扔便便");
        f52295d.put("image_emoticon64", "惊恐");
        f52295d.put("image_emoticon65", "哎呦");
        f52295d.put("image_emoticon66", "小乖");
        f52295d.put("image_emoticon67", "捂嘴笑");
        f52295d.put("image_emoticon68", "你懂的");
        f52295d.put("image_emoticon69", "what");
        f52295d.put("image_emoticon70", "酸爽");
        f52295d.put("image_emoticon71", "呀咩爹");
        f52295d.put("image_emoticon72", "笑尿");
        f52295d.put("image_emoticon73", "挖鼻");
        f52295d.put("image_emoticon74", "犀利");
        f52295d.put("image_emoticon75", "小红脸");
        f52295d.put("image_emoticon76", "懒得理");
        f52295d.put("image_emoticon77", "沙发");
        f52295d.put("image_emoticon78", "手纸");
        f52295d.put("image_emoticon79", "香蕉");
        f52295d.put("image_emoticon80", "便便");
        f52295d.put("image_emoticon81", "药丸");
        f52295d.put("image_emoticon82", "红领巾");
        f52295d.put("image_emoticon83", "蜡烛");
        f52295d.put("image_emoticon84", "三道杠");
        f52295d.put("image_emoticon85", "暗中观察");
        f52295d.put("image_emoticon86", "吃瓜");
        f52295d.put("image_emoticon87", "喝酒");
        f52295d.put("image_emoticon88", "嘿嘿嘿");
        f52295d.put("image_emoticon89", "噗");
        f52295d.put("image_emoticon90", "困成狗");
        f52295d.put("image_emoticon91", "微微一笑");
        f52295d.put("image_emoticon92", "托腮");
        f52295d.put("image_emoticon93", "摊手");
        f52295d.put("image_emoticon94", "柯基暗中观察");
        f52295d.put("image_emoticon95", "欢呼");
        f52295d.put("image_emoticon96", "炸药");
        f52295d.put("image_emoticon97", "突然兴奋");
        f52295d.put("image_emoticon98", "紧张");
        f52295d.put("image_emoticon99", "黑头瞪眼");
        f52295d.put("image_emoticon100", "黑头高兴");
        f52295d.put("image_emoticon125", "奥特曼");
        f52295d.put("image_emoticon126", "不听");
        f52295d.put("image_emoticon127", "干饭");
        f52295d.put("image_emoticon128", "望远镜");
        f52295d.put("image_emoticon101", "不跟丑人说话");
        f52295d.put("image_emoticon102", "么么哒");
        f52295d.put("image_emoticon103", "亲亲才能起来");
        f52295d.put("image_emoticon104", "伦家只是宝宝");
        f52295d.put("image_emoticon105", "你是我的人");
        f52295d.put("image_emoticon106", "假装看不见");
        f52295d.put("image_emoticon107", "单身等撩");
        f52295d.put("image_emoticon108", "吓到宝宝了");
        f52295d.put("image_emoticon109", "哈哈哈");
        f52295d.put("image_emoticon110", "嗯嗯");
        f52295d.put("image_emoticon111", "好幸福");
        f52295d.put("image_emoticon112", "宝宝不开心");
        f52295d.put("image_emoticon113", "小姐姐别走");
        f52295d.put("image_emoticon114", "小姐姐在吗");
        f52295d.put("image_emoticon115", "小姐姐来啦");
        f52295d.put("image_emoticon116", "小姐姐来玩呀");
        f52295d.put("image_emoticon117", "我养你");
        f52295d.put("image_emoticon118", "我是不会骗你的");
        f52295d.put("image_emoticon119", "扎心了");
        f52295d.put("image_emoticon120", "无聊");
        f52295d.put("image_emoticon121", "月亮代表我的心");
        f52295d.put("image_emoticon122", "来追我呀");
        f52295d.put("image_emoticon123", "爱你的形状");
        f52295d.put("image_emoticon124", "白眼");
        f52295d.put("ali_001", "赖皮");
        f52295d.put("ali_002", "感动");
        f52295d.put("ali_003", "十分惊讶");
        f52295d.put("ali_004", "怒气");
        f52295d.put("ali_005", "哭泣");
        f52295d.put("ali_006", "吃惊");
        f52295d.put("ali_007", "嘲弄");
        f52295d.put("ali_008", "飘过");
        f52295d.put("ali_009", "转圈哭");
        f52295d.put("ali_010", "神经病");
        f52295d.put("ali_011", "揪耳朵");
        f52295d.put("ali_012", "惊汗");
        f52295d.put("ali_013", "隐身");
        f52295d.put("ali_014", "不要嘛");
        f52295d.put("ali_015", "遁");
        f52295d.put("ali_016", "不公平");
        f52295d.put("ali_017", "爬来了");
        f52295d.put("ali_018", "蛋花哭");
        f52295d.put("ali_019", "温暖");
        f52295d.put("ali_020", "点头");
        f52295d.put("ali_021", "撒钱");
        f52295d.put("ali_022", "献花");
        f52295d.put("ali_023", "寒");
        f52295d.put("ali_024", "傻笑");
        f52295d.put("ali_025", "扭扭");
        f52295d.put("ali_026", "疯");
        f52295d.put("ali_027", "抓狂");
        f52295d.put("ali_028", "抓");
        f52295d.put("ali_029", "蜷");
        f52295d.put("ali_030", "挠墙");
        f52295d.put("ali_031", "狂笑");
        f52295d.put("ali_032", "抱枕");
        f52295d.put("ali_033", "吼叫");
        f52295d.put("ali_034", "嚷");
        f52295d.put("ali_035", "唠叨");
        f52295d.put("ali_036", "捏脸");
        f52295d.put("ali_037", "爆笑");
        f52295d.put("ali_038", "郁闷");
        f52295d.put("ali_039", "潜水");
        f52295d.put("ali_040", "十分开心");
        f52295d.put("ali_041", "冷笑话");
        f52295d.put("ali_042", "顶！");
        f52295d.put("ali_043", "潜");
        f52295d.put("ali_044", "画圈圈");
        f52295d.put("ali_045", "玩电脑");
        f52295d.put("ali_046", "狂吐");
        f52295d.put("ali_047", "哭着跑");
        f52295d.put("ali_048", "阿狸侠");
        f52295d.put("ali_049", "冷死了");
        f52295d.put("ali_050", "惆怅~");
        f52295d.put("ali_051", "摸头");
        f52295d.put("ali_052", "蹭");
        f52295d.put("ali_053", "打滚");
        f52295d.put("ali_054", "叩拜");
        f52295d.put("ali_055", "摸");
        f52295d.put("ali_056", "数钱");
        f52295d.put("ali_057", "拖走");
        f52295d.put("ali_058", "热");
        f52295d.put("ali_059", "加1");
        f52295d.put("ali_060", "压力");
        f52295d.put("ali_061", "表逼我");
        f52295d.put("ali_062", "人呢");
        f52295d.put("ali_063", "摇晃");
        f52295d.put("ali_064", "打地鼠");
        f52295d.put("ali_065", "这个屌");
        f52295d.put("ali_066", "恐慌");
        f52295d.put("ali_067", "晕乎乎");
        f52295d.put("ali_068", "浮云");
        f52295d.put("ali_069", "给力");
        f52295d.put("ali_070", "杯具了");
        f52295d.put("b01", "微笑");
        f52295d.put("b02", "帅哥");
        f52295d.put("b03", "美女");
        f52295d.put("b04", "老大");
        f52295d.put("b05", "哈哈哈");
        f52295d.put("b06", "奸笑");
        f52295d.put("b07", "傻乐");
        f52295d.put("b08", "飞吻");
        f52295d.put("b09", "害羞");
        f52295d.put("b10", "花痴");
        f52295d.put("b11", "憧憬");
        f52295d.put("b12", "你牛");
        f52295d.put("b13", "鼓掌");
        f52295d.put("b14", "可爱");
        f52295d.put("b15", "太委屈");
        f52295d.put("b16", "大哭");
        f52295d.put("b17", "泪奔");
        f52295d.put("b18", "寻死");
        f52295d.put("b19", "非常惊讶");
        f52295d.put("b20", "表示疑问");
        f52295d.put("yz_001", "焦糖舞");
        f52295d.put("yz_002", "翻滚");
        f52295d.put("yz_003", "拍屁股做鬼脸");
        f52295d.put("yz_004", "不");
        f52295d.put("yz_005", "河蟹掉啦");
        f52295d.put("yz_006", "哦耶");
        f52295d.put("yz_007", "我倒");
        f52295d.put("yz_008", "投降");
        f52295d.put("shoubai_emoji_face_01", "微笑");
        f52295d.put("shoubai_emoji_face_02", "开心");
        f52295d.put("shoubai_emoji_face_03", "期待");
        f52295d.put("shoubai_emoji_face_04", "大笑");
        f52295d.put("shoubai_emoji_face_05", "鼓掌");
        f52295d.put("shoubai_emoji_face_06", "悠闲");
        f52295d.put("shoubai_emoji_face_07", "笑哭");
        f52295d.put("shoubai_emoji_face_08", "不要啊");
        f52295d.put("shoubai_emoji_face_09", "啊");
        f52295d.put("shoubai_emoji_face_10", "哟");
        f52295d.put("shoubai_emoji_face_11", "汗");
        f52295d.put("shoubai_emoji_face_12", "抠鼻");
        f52295d.put("shoubai_emoji_face_13", "哼");
        f52295d.put("shoubai_emoji_face_14", "发怒");
        f52295d.put("shoubai_emoji_face_15", "委屈");
        f52295d.put("shoubai_emoji_face_16", "不高兴");
        f52295d.put("shoubai_emoji_face_17", "囧");
        f52295d.put("shoubai_emoji_face_18", "惊哭");
        f52295d.put("shoubai_emoji_face_19", "大哭");
        f52295d.put("shoubai_emoji_face_20", "流泪");
        f52295d.put("shoubai_emoji_face_21", "害羞");
        f52295d.put("shoubai_emoji_face_22", "亲亲");
        f52295d.put("shoubai_emoji_face_23", "色");
        f52295d.put("shoubai_emoji_face_24", "舔屏");
        f52295d.put("shoubai_emoji_face_25", "得意");
        f52295d.put("shoubai_emoji_face_26", "疑问");
        f52295d.put("shoubai_emoji_face_27", "晕");
        f52295d.put("shoubai_emoji_face_28", "大哈");
        f52295d.put("shoubai_emoji_face_29", "二哈");
        f52295d.put("shoubai_emoji_face_30", "三哈");
        f52295d.put("shoubai_emoji_face_31", "白眼");
        f52295d.put("shoubai_emoji_face_32", "阴险");
        f52295d.put("shoubai_emoji_face_33", "你懂的");
        f52295d.put("shoubai_emoji_face_34", "偷笑");
        f52295d.put("shoubai_emoji_face_35", "睡觉");
        f52295d.put("shoubai_emoji_face_36", "哈欠");
        f52295d.put("shoubai_emoji_face_37", "再见");
        f52295d.put("shoubai_emoji_face_38", "鄙视");
        f52295d.put("shoubai_emoji_face_39", "抓狂");
        f52295d.put("shoubai_emoji_face_40", "咒骂");
        f52295d.put("shoubai_emoji_face_41", "衰");
        f52295d.put("shoubai_emoji_face_42", "骷髅");
        f52295d.put("shoubai_emoji_face_43", "嘘");
        f52295d.put("shoubai_emoji_face_44", "闭嘴");
        f52295d.put("shoubai_emoji_face_45", "呆");
        f52295d.put("shoubai_emoji_face_46", "什么鬼");
        f52295d.put("shoubai_emoji_face_47", "吐");
        f52295d.put("shoubai_emoji_face_48", "已阅");
        f52295d.put("shoubai_emoji_face_49", "同上");
        f52295d.put("shoubai_emoji_face_50", "友军");
        f52295d.put("shoubai_emoji_face_51", "爱钱");
        f52295d.put("shoubai_emoji_face_52", "Freestyle");
        f52295d.put("shoubai_emoji_face_53", "国宝");
        f52295d.put("shoubai_emoji_face_54", "羊驼");
        f52295d.put("shoubai_emoji_face_55", "鲜花");
        f52295d.put("shoubai_emoji_face_56", "中国加油");
        f52295d.put("shoubai_emoji_face_57", "庆祝");
        f52295d.put("shoubai_emoji_face_58", "生日蛋糕");
        f52295d.put("shoubai_emoji_face_59", "MicDrop");
        f52295d.put("shoubai_emoji_face_60", "赞同");
        f52295d.put("shoubai_emoji_face_61", "药丸");
        f52295d.put("shoubai_emoji_face_62", "蜡烛");
        f52295d.put("shoubai_emoji_face_63", "鸡蛋");
        f52295d.put("shoubai_emoji_face_64", "浪");
        f52295d.put("shoubai_emoji_face_65", "打call");
        f52295d.put("shoubai_emoji_face_66", "尬笑");
        f52295d.put("shoubai_emoji_face_67", "坏笑");
        f52295d.put("shoubai_emoji_face_68", "没眼看");
        f52295d.put("shoubai_emoji_face_69", "嘿哈");
        f52295d.put("shoubai_emoji_face_70", "前面的别走");
        f52295d.put("shoubai_emoji_face_71", "滑稽");
        f52295d.put("shoubai_emoji_face_72", "捂脸");
        f52295d.put("shoubai_emoji_face_73", "左捂脸");
        f52295d.put("shoubai_emoji_face_74", "666");
        f52295d.put("shoubai_emoji_face_75", "2018");
        f52295d.put("shoubai_emoji_face_76", "福");
        f52295d.put("shoubai_emoji_face_77", "红包");
        f52295d.put("shoubai_emoji_face_78", "鞭炮");
        f52295d.put("shoubai_emoji_face_79", "财神");
        f52295d.put("shoubai_emoji_face_80", "饺子");
        f52295d.put("shoubai_emoji_face_81", "车票");
        f52295d.put("shoubai_emoji_face_82", "火车");
        f52295d.put("shoubai_emoji_face_83", "飞机");
        f52295d.put("shoubai_emoji_face_84", "射门");
        f52295d.put("shoubai_emoji_face_85", "红牌");
        f52295d.put("shoubai_emoji_face_86", "黄牌");
        f52295d.put("shoubai_emoji_face_87", "哨子");
        f52295d.put("shoubai_emoji_face_88", "比分");
        f52295d.put("shoubai_emoji_face_89", "啤酒");
        f52295d.put("shoubai_emoji_face_90", "足球");
        f52295d.put("shoubai_emoji_face_91", "大力神杯");
        f52295d.put("shoubai_emoji_face_92", "锦鲤");
        f52295d.put("shoubai_emoji_face_93", "2019");
        f52295d.put("shoubai_emoji_face_94", "猪年");
        f52295d.put("shoubai_emoji_face_95", "双手鼓掌");
        f52295d.put("shoubai_emoji_face_96", "火焰");
        f52295d.put("shoubai_emoji_face_97", "祈福");
        f52295d.put("shoubai_emoji_face_98", "亲吻");
        f52295d.put("shoubai_emoji_face_99", "天使");
        f52295d.put("shoubai_emoji_face_100", "樱花");
        f52295d.put("shoubai_emoji_face_101", "加油");
        f52295d.put("shoubai_emoji_face_102", "泡泡枪");
        f52295d.put("shoubai_emoji_face_103", "气球");
        f52295d.put("shoubai_emoji_face_104", "棒棒糖");
        f52295d.put("shoubai_emoji_face_105", "小黄鸭");
        f52295d.put("shoubai_emoji_face_106", "粽子");
        f52295d.put("bearchildren_01", "熊-88");
        f52295d.put("bearchildren_02", "熊-HI");
        f52295d.put("bearchildren_03", "熊-人艰不拆");
        f52295d.put("bearchildren_04", "熊-啥");
        f52295d.put("bearchildren_05", "熊-大哭");
        f52295d.put("bearchildren_06", "熊-失落");
        f52295d.put("bearchildren_07", "熊-怒赞");
        f52295d.put("bearchildren_08", "熊-惊呆了");
        f52295d.put("bearchildren_09", "熊-李菊福");
        f52295d.put("bearchildren_10", "熊-来信砍");
        f52295d.put("bearchildren_11", "熊-欢迎入群");
        f52295d.put("bearchildren_12", "熊-牛闪闪");
        f52295d.put("bearchildren_13", "熊-生日快乐");
        f52295d.put("bearchildren_14", "熊-石化");
        f52295d.put("bearchildren_15", "熊-羞羞哒");
        f52295d.put("bearchildren_16", "熊-肥皂必杀");
        f52295d.put("bearchildren_17", "熊-谢谢你");
        f52295d.put("bearchildren_18", "熊-跳舞");
        f52295d.put("bearchildren_19", "熊-霹雳舞");
        f52295d.put("bearchildren_20", "熊-鼓掌");
    }

    @Override // d.b.i0.a0.a
    public a.C1077a a(Context context, String str) {
        return null;
    }

    @Override // d.b.i0.a0.a
    public int b() {
        return f52293b.size();
    }

    @Override // d.b.i0.a0.a
    public int c(String str) {
        Integer num = f52292a.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // d.b.i0.a0.a
    public String d(String str) {
        return f52295d.get(str);
    }

    @Override // d.b.i0.a0.a
    public int e(String str) {
        Integer num = f52294c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
