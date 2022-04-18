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
public class ja9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public String b;
    public MediaMuxer c;
    public int d;
    public int e;
    public MediaFormat f;
    public MediaFormat g;
    public za9 h;

    public ja9(List<String> list, String str, za9 za9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, za9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ac9.e("VideoComposer", list.size() + " composer to " + str);
        this.a = list;
        this.b = str;
        this.h = za9Var;
    }

    public final long a(long j, String str) throws IOException {
        InterceptResult invokeJL;
        int i;
        int i2;
        ia9 ia9Var;
        int i3;
        ia9 ia9Var2;
        int i4;
        ia9 ia9Var3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            String str3 = "VideoComposer";
            ac9.e("VideoComposer", j + " compose " + str);
            ia9 ia9Var4 = new ia9();
            ia9Var4.m(str, FileUtils.VIDEO_FILE_START);
            int d = ia9Var4.d();
            ia9 ia9Var5 = null;
            if (d < 0) {
                ia9Var4.j();
                ia9Var4 = null;
            } else {
                ia9Var4.l(this.e);
            }
            ia9 ia9Var6 = new ia9();
            ia9Var6.m(str, "audio/");
            int d2 = ia9Var6.d();
            if (d2 < 0) {
                ia9Var6.j();
            } else {
                ia9Var6.l(this.d);
                ia9Var5 = ia9Var6;
            }
            boolean z = ia9Var4 == null;
            boolean z2 = ia9Var5 == null;
            long j2 = 0;
            long j3 = 0;
            while (true) {
                if (z && z2) {
                    break;
                }
                if (!z2 && (z || ia9Var5.e() - ia9Var4.e() <= 50000)) {
                    i = this.d;
                    i3 = d2;
                    i2 = i3;
                    ia9Var = ia9Var5;
                } else {
                    i = this.e;
                    i2 = d2;
                    ia9Var = ia9Var4;
                    i3 = d;
                }
                MediaCodec.BufferInfo h = ia9Var.h();
                if (h == null) {
                    i4 = d;
                    ia9 ia9Var7 = ia9Var;
                    if (ia9Var7 == ia9Var4) {
                        j2 = ia9Var4.e();
                        d2 = i2;
                        d = i4;
                        z = true;
                    } else if (ia9Var7 == ia9Var5) {
                        j3 = ia9Var5.e();
                        d2 = i2;
                        d = i4;
                        z2 = true;
                    } else {
                        ia9Var2 = ia9Var4;
                        ia9Var3 = ia9Var5;
                        str2 = str3;
                    }
                } else {
                    ia9Var2 = ia9Var4;
                    i4 = d;
                    ia9 ia9Var8 = ia9Var;
                    if (ia9Var8.f() != i3) {
                        StringBuilder sb = new StringBuilder();
                        ia9Var3 = ia9Var5;
                        sb.append("WEIRD: got sample from track ");
                        sb.append(ia9Var8.f());
                        sb.append(", expected ");
                        sb.append(i3);
                        ac9.e(str3, sb.toString());
                    } else {
                        ia9Var3 = ia9Var5;
                    }
                    str2 = str3;
                    h.presentationTimeUs += j;
                    this.c.writeSampleData(i, ia9Var8.c(), h);
                    ia9Var8.a();
                }
                str3 = str2;
                d2 = i2;
                d = i4;
                ia9Var4 = ia9Var2;
                ia9Var5 = ia9Var3;
            }
            long max = j + Math.max(j2, j3) + 10000;
            za9 za9Var = this.h;
            if (za9Var != null) {
                za9Var.b(max);
            }
            ac9.e(str3, "finish one file, ptsOffset " + max);
            if (ia9Var4 != null) {
                ia9Var4.j();
            }
            if (ia9Var5 != null) {
                ia9Var5.j();
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
                    ia9 ia9Var = new ia9();
                    try {
                        ia9Var.m(str, FileUtils.VIDEO_FILE_START);
                        if (!z) {
                            MediaFormat mediaFormat = ia9Var.g().a;
                            this.g = mediaFormat;
                            if (mediaFormat == null) {
                                ac9.e("VideoComposer", "No video track found in " + str);
                            } else {
                                z = true;
                            }
                        }
                        if (!z2) {
                            MediaFormat mediaFormat2 = ia9Var.b().a;
                            this.f = mediaFormat2;
                            if (mediaFormat2 == null) {
                                ac9.e("VideoComposer", "No audio track found in " + str);
                            } else {
                                z2 = true;
                            }
                        }
                    } catch (Exception e) {
                        ac9.e("VideoComposer", e.getMessage());
                        e.printStackTrace();
                    }
                    ia9Var.j();
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
                    ac9.e("VideoComposer", "Muxer close error. No data was written");
                }
                this.c = null;
            }
            ac9.j("VideoComposer", "video join finished");
            return true;
        }
        return invokeL.booleanValue;
    }
}
