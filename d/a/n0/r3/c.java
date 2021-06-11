package d.a.n0.r3;

import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f63684a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";

    /* renamed from: b  reason: collision with root package name */
    public static final String f63685b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f63686c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f63687d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f63688e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f63689f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f63685b = sb.toString();
        f63686c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f63687d = sb2.toString();
        f63688e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f63689f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
