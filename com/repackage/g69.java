package com.repackage;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.util.List;
@TargetApi(18)
/* loaded from: classes6.dex */
public class g69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public w69 h;

    public g69(List<String> list, String str, w69 w69Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, w69Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        x79.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = w69Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        int i;
        int i2;
        f69 f69Var;
        int i3;
        f69 f69Var2;
        int i4;
        f69 f69Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            x79.e("VideoComposer", j + " compose " + str);
            f69 f69Var4 = new f69();
            f69Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = f69Var4.d();
            f69 f69Var5 = null;
            if (d < 0) {
                f69Var4.j();
                f69Var4 = null;
            } else {
                f69Var4.l(this.e);
            }
            f69 f69Var6 = new f69();
            f69Var6.m(str, "audio/");
            int d2 = f69Var6.d();
            if (d2 < 0) {
                f69Var6.j();
            } else {
                f69Var6.l(this.d);
                f69Var5 = f69Var6;
            }
            boolean z = f69Var4 == null;
            boolean z2 = f69Var5 == null;
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || f69Var5.e() - f69Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    f69Var = f69Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    f69Var = f69Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = f69Var.h();
                if (h == null) {
                    i4 = d;
                    f69 f69Var7 = f69Var;
                    if (f69Var7 == f69Var4) {
                        j2 = f69Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (f69Var7 == f69Var5) {
                        j3 = f69Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        f69Var2 = f69Var4;
                        f69Var3 = f69Var5;
                        str2 = str3;
                    }
                } else {
                    f69Var2 = f69Var4;
                    i4 = d;
                    f69 f69Var8 = f69Var;
                    if (f69Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        f69Var3 = f69Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(f69Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        x79.e(str3, sb.toString());
                    } else {
                        f69Var3 = f69Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, f69Var8.c(), h);
                    f69Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                f69Var4 = f69Var2;
                f69Var5 = f69Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            w69 w69Var = this.h;
            if (w69Var != null) {
                w69Var.b(max);
            }
            x79.e(str3, "finish one file, ptsOffset " + max);
            if (f69Var4 != null) {
                f69Var4.j();
            }
            if (f69Var5 != null) {
                f69Var5.j();
            }
            return max;
        }
        return invokeJL.longValue;
    }

    public boolean b(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb)) == null) {
            boolean z = false;
            boolean z2 = false;
            for (String str : this.a) {
                try {
                    f69 f69Var = new f69();
                    try {
                        f69Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = f69Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                x79.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = f69Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                x79.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        x79.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    f69Var.j();
                    if (z && z2) {
                        break;
                    }
                } catch (Exception e2) {
                    if (sb != null) {
                        sb.append("VideoSplicer codec 录制视频拼接过程中发生异常:" + e2.getMessage());
                    }
                    e2.printStackTrace();
                    return false;
                }
            }
            MediaMuxer mediaMuxer = new MediaMuxer(this.b, 0);
            this.c = mediaMuxer;
            if (z) {
                this.e = mediaMuxer.addTrack(this.g);
            }
            if (z2) {
                this.d = this.c.addTrack(this.f);
            }
            this.c.start();
            long j = 0;
            for (String str2 : this.a) {
                j = a(j, str2);
            }
            if (this.c != null) {
                try {
                    this.c.stop();
                    this.c.release();
                } catch (Exception unused) {
                    x79.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            x79.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
