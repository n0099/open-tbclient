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
/* loaded from: classes5.dex */
public class aa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public qa9 h;

    public aa9(List<String> list, String str, qa9 qa9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, qa9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        rb9.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = qa9Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        int i;
        int i2;
        z99 z99Var;
        int i3;
        z99 z99Var2;
        int i4;
        z99 z99Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            rb9.e("VideoComposer", j + " compose " + str);
            z99 z99Var4 = new z99();
            z99Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = z99Var4.d();
            z99 z99Var5 = null;
            if (d < 0) {
                z99Var4.j();
                z99Var4 = null;
            } else {
                z99Var4.l(this.e);
            }
            z99 z99Var6 = new z99();
            z99Var6.m(str, "audio/");
            int d2 = z99Var6.d();
            if (d2 < 0) {
                z99Var6.j();
            } else {
                z99Var6.l(this.d);
                z99Var5 = z99Var6;
            }
            boolean z = z99Var4 == null;
            boolean z2 = z99Var5 == null;
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || z99Var5.e() - z99Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    z99Var = z99Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    z99Var = z99Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = z99Var.h();
                if (h == null) {
                    i4 = d;
                    z99 z99Var7 = z99Var;
                    if (z99Var7 == z99Var4) {
                        j2 = z99Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (z99Var7 == z99Var5) {
                        j3 = z99Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        z99Var2 = z99Var4;
                        z99Var3 = z99Var5;
                        str2 = str3;
                    }
                } else {
                    z99Var2 = z99Var4;
                    i4 = d;
                    z99 z99Var8 = z99Var;
                    if (z99Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        z99Var3 = z99Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(z99Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        rb9.e(str3, sb.toString());
                    } else {
                        z99Var3 = z99Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, z99Var8.c(), h);
                    z99Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                z99Var4 = z99Var2;
                z99Var5 = z99Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            qa9 qa9Var = this.h;
            if (qa9Var != null) {
                qa9Var.b(max);
            }
            rb9.e(str3, "finish one file, ptsOffset " + max);
            if (z99Var4 != null) {
                z99Var4.j();
            }
            if (z99Var5 != null) {
                z99Var5.j();
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
                    z99 z99Var = new z99();
                    try {
                        z99Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = z99Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                rb9.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = z99Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                rb9.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        rb9.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    z99Var.j();
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
                    rb9.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            rb9.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
