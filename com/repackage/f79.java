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
public class f79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public v79 h;

    public f79(List<String> list, String str, v79 v79Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, v79Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        w89.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = v79Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        int i;
        int i2;
        e79 e79Var;
        int i3;
        e79 e79Var2;
        int i4;
        e79 e79Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            w89.e("VideoComposer", j + " compose " + str);
            e79 e79Var4 = new e79();
            e79Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = e79Var4.d();
            e79 e79Var5 = null;
            if (d < 0) {
                e79Var4.j();
                e79Var4 = null;
            } else {
                e79Var4.l(this.e);
            }
            e79 e79Var6 = new e79();
            e79Var6.m(str, "audio/");
            int d2 = e79Var6.d();
            if (d2 < 0) {
                e79Var6.j();
            } else {
                e79Var6.l(this.d);
                e79Var5 = e79Var6;
            }
            boolean z = e79Var4 == null;
            boolean z2 = e79Var5 == null;
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || e79Var5.e() - e79Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    e79Var = e79Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    e79Var = e79Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = e79Var.h();
                if (h == null) {
                    i4 = d;
                    e79 e79Var7 = e79Var;
                    if (e79Var7 == e79Var4) {
                        j2 = e79Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (e79Var7 == e79Var5) {
                        j3 = e79Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        e79Var2 = e79Var4;
                        e79Var3 = e79Var5;
                        str2 = str3;
                    }
                } else {
                    e79Var2 = e79Var4;
                    i4 = d;
                    e79 e79Var8 = e79Var;
                    if (e79Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        e79Var3 = e79Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(e79Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        w89.e(str3, sb.toString());
                    } else {
                        e79Var3 = e79Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, e79Var8.c(), h);
                    e79Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                e79Var4 = e79Var2;
                e79Var5 = e79Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            v79 v79Var = this.h;
            if (v79Var != null) {
                v79Var.b(max);
            }
            w89.e(str3, "finish one file, ptsOffset " + max);
            if (e79Var4 != null) {
                e79Var4.j();
            }
            if (e79Var5 != null) {
                e79Var5.j();
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
                    e79 e79Var = new e79();
                    try {
                        e79Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = e79Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                w89.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = e79Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                w89.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        w89.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    e79Var.j();
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
                    w89.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            w89.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
