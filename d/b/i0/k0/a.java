package d.b.i0.k0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.EmotionUtil;
import d.b.h0.a0.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f56418a = Pattern.compile("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f56419b = Pattern.compile("#\\([^#\\)\\(]+\\)$");

    public static int a(String str) {
        CustomResponsedMessage runTask;
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = f56418a.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                if (MessageManager.getInstance().findTask(2004608) != null && (runTask = MessageManager.getInstance().runTask(2004608, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                    i++;
                }
            }
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(str);
            while (matcher2.find()) {
                String[] split = matcher2.group().split(",");
                if (split != null && split.length == 5) {
                    i++;
                }
            }
            Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(str);
            while (matcher3.find()) {
                String[] split2 = matcher3.group().split(",");
                if (split2 != null && split2.length == 6) {
                    i++;
                }
            }
        }
        return i;
    }

    public static String b(String str) {
        String replaceAll = str.replaceAll(d.f49684f, EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        Matcher matcher = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(replaceAll);
        StringBuilder sb = new StringBuilder(replaceAll);
        int i = 0;
        while (matcher.find()) {
            String[] split = matcher.group().split(",");
            if (split != null && split.length == 6) {
                StringBuilder sb2 = new StringBuilder();
                int start = matcher.start() - i;
                int end = matcher.end() - i;
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (i2 != 1) {
                        sb2.append(split[i2]);
                        if (i2 < split.length - 1) {
                            sb2.append(",");
                        }
                    }
                }
                i += (end - start) - sb2.toString().length();
                if (start >= 0 && end <= sb.length()) {
                    sb.replace(start, end, sb2.toString());
                }
            }
        }
        return sb.toString();
    }
}
