package d.a.j0.q3;

import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f59107a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";

    /* renamed from: b  reason: collision with root package name */
    public static final String f59108b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f59109c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f59110d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f59111e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f59112f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f59108b = sb.toString();
        f59109c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f59110d = sb2.toString();
        f59111e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f59112f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
