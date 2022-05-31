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
/* loaded from: classes7.dex */
public class y59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public o69 h;

    public y59(List<String> list, String str, o69 o69Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, o69Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p79.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = o69Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        int i;
        int i2;
        x59 x59Var;
        int i3;
        x59 x59Var2;
        int i4;
        x59 x59Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            p79.e("VideoComposer", j + " compose " + str);
            x59 x59Var4 = new x59();
            x59Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = x59Var4.d();
            x59 x59Var5 = null;
            if (d < 0) {
                x59Var4.j();
                x59Var4 = null;
            } else {
                x59Var4.l(this.e);
            }
            x59 x59Var6 = new x59();
            x59Var6.m(str, "audio/");
            int d2 = x59Var6.d();
            if (d2 < 0) {
                x59Var6.j();
            } else {
                x59Var6.l(this.d);
                x59Var5 = x59Var6;
            }
            boolean z = x59Var4 == null;
            boolean z2 = x59Var5 == null;
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || x59Var5.e() - x59Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    x59Var = x59Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    x59Var = x59Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = x59Var.h();
                if (h == null) {
                    i4 = d;
                    x59 x59Var7 = x59Var;
                    if (x59Var7 == x59Var4) {
                        j2 = x59Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (x59Var7 == x59Var5) {
                        j3 = x59Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        x59Var2 = x59Var4;
                        x59Var3 = x59Var5;
                        str2 = str3;
                    }
                } else {
                    x59Var2 = x59Var4;
                    i4 = d;
                    x59 x59Var8 = x59Var;
                    if (x59Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        x59Var3 = x59Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(x59Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        p79.e(str3, sb.toString());
                    } else {
                        x59Var3 = x59Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, x59Var8.c(), h);
                    x59Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                x59Var4 = x59Var2;
                x59Var5 = x59Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            o69 o69Var = this.h;
            if (o69Var != null) {
                o69Var.b(max);
            }
            p79.e(str3, "finish one file, ptsOffset " + max);
            if (x59Var4 != null) {
                x59Var4.j();
            }
            if (x59Var5 != null) {
                x59Var5.j();
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
                    x59 x59Var = new x59();
                    try {
                        x59Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = x59Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                p79.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = x59Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                p79.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        p79.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    x59Var.j();
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
                    p79.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            p79.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
