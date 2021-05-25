package d.a.n0.r3;

import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f59993a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";

    /* renamed from: b  reason: collision with root package name */
    public static final String f59994b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f59995c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f59996d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f59997e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f59998f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f59994b = sb.toString();
        f59995c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f59996d = sb2.toString();
        f59997e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f59998f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
