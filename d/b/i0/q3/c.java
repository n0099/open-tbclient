package d.b.i0.q3;

import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f60556a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";

    /* renamed from: b  reason: collision with root package name */
    public static final String f60557b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f60558c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f60559d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f60560e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f60561f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f60557b = sb.toString();
        f60558c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f60559d = sb2.toString();
        f60560e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f60561f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
