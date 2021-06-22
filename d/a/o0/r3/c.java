package d.a.o0.r3;

import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f63809a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";

    /* renamed from: b  reason: collision with root package name */
    public static final String f63810b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f63811c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f63812d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f63813e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f63814f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f63810b = sb.toString();
        f63811c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f63812d = sb2.toString();
        f63813e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f63814f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
