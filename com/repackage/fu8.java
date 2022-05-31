package com.repackage;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.faceunity.encoder.MediaCodecHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class fu8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fu8 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends MediaMetadataRetriever implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public String b;
        public boolean c;
        public volatile boolean d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ou8 a;
            public final /* synthetic */ nu8 b;
            public final /* synthetic */ b c;

            public a(b bVar, ou8 ou8Var, nu8 nu8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, ou8Var, nu8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = ou8Var;
                this.b = nu8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<iu8> arrayList = new ArrayList();
                    ArrayList<iu8> arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (iu8 iu8Var : this.a.e) {
                        int i = iu8Var.g;
                        if (i == 0) {
                            arrayList.add(iu8Var);
                        } else if (i == 1) {
                            arrayList2.add(iu8Var);
                        }
                    }
                    if (!u79.e(arrayList)) {
                        for (iu8 iu8Var2 : arrayList) {
                            Bitmap d = ju8.f().d(iu8Var2.a);
                            if (d == null || d.isRecycled()) {
                                d = q79.e(iu8Var2.b, iu8Var2.h, iu8Var2.i, iu8Var2.c);
                                ju8.f().g().b(iu8Var2.a, d);
                                ju8.f().e().c(iu8Var2.a, d);
                            }
                            iu8Var2.e = d;
                            iu8Var2.a();
                        }
                    }
                    if (!u79.e(arrayList2)) {
                        for (iu8 iu8Var3 : arrayList2) {
                            Bitmap d2 = ju8.f().d(iu8Var3.a);
                            if (d2 != null && !d2.isRecycled()) {
                                iu8Var3.e = d2;
                                iu8Var3.a();
                            } else {
                                arrayList3.add(iu8Var3);
                            }
                        }
                    }
                    if (u79.e(arrayList3)) {
                        this.c.k(this.b);
                        return;
                    }
                    this.a.e = arrayList3;
                    if (!this.c.g()) {
                        this.c.j(this.a);
                    } else {
                        this.c.i(this.a);
                    }
                    this.c.k(this.b);
                }
            }
        }

        /* renamed from: com.repackage.fu8$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0428b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nu8 a;
            public final /* synthetic */ b b;

            public RunnableC0428b(b bVar, nu8 nu8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, nu8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = nu8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                nu8 nu8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nu8Var = this.a) == null) {
                    return;
                }
                nu8Var.a(this.b);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable, java.io.Closeable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                release();
            }
        }

        public final void d(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, BaseOutputSurface baseOutputSurface, List<iu8> list) throws IOException {
            String str;
            int i2;
            long j;
            int i3;
            int dequeueInputBuffer;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaExtractor, Integer.valueOf(i), mediaCodec, baseOutputSurface, list}) == null) {
                ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                long j2 = 0;
                int i4 = 0;
                if (u79.b(list) == 1) {
                    iu8 iu8Var = (iu8) u79.c(list, 0);
                    long j3 = iu8Var != null ? iu8Var.d : 0L;
                    if (j3 <= 0) {
                        j3 = 1;
                    }
                    mediaExtractor.getSampleTime();
                    mediaExtractor.seekTo(j3, 0);
                    if (mediaExtractor.getSampleTime() > j3) {
                        mediaExtractor.seekTo(0L, 2);
                    }
                }
                int i5 = 0;
                boolean z = false;
                boolean z2 = false;
                while (!z && !this.a) {
                    if (z2 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                        str = "VideoFrameMetadataRetriever";
                        i2 = i5;
                        j = j2;
                    } else {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i4);
                        if (readSampleData < 0) {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j2;
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            z2 = true;
                        } else {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j2;
                            if (mediaExtractor.getSampleTrackIndex() != i) {
                                p79.l(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                            }
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                    }
                    if (z) {
                        i3 = i2;
                    } else {
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                            if (dequeueOutputBuffer == -2) {
                                mediaCodec.getOutputFormat();
                            } else if (dequeueOutputBuffer < 0) {
                                p79.c(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                            } else {
                                boolean z3 = (bufferInfo.flags & 4) != 0 ? true : z;
                                boolean z4 = bufferInfo.size != 0;
                                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z4);
                                if (z4) {
                                    i3 = i2;
                                    iu8 iu8Var2 = (iu8) u79.c(list, i3);
                                    baseOutputSurface.awaitNewImage();
                                    baseOutputSurface.drawImage((int) (((float) bufferInfo.presentationTimeUs) / 1000.0f));
                                    if (iu8Var2 != null) {
                                        long j4 = iu8Var2.d;
                                        if (j4 <= j) {
                                            j4 = 1;
                                        } else if (i3 == list.size() - 1) {
                                            j4 -= 800000;
                                        }
                                        if (bufferInfo.presentationTimeUs >= j4) {
                                            iu8Var2.e = baseOutputSurface.getFrameBitmap();
                                            ju8.f().g().b(iu8Var2.a, iu8Var2.e);
                                            iu8Var2.a();
                                            ju8.f().e().c(iu8Var2.a, iu8Var2.e);
                                            if (i3 == list.size() - 1) {
                                                z3 = true;
                                            }
                                            i5 = i3 + 1;
                                            z = z3;
                                            j2 = j;
                                            i4 = 0;
                                        }
                                    }
                                } else {
                                    i3 = i2;
                                }
                                z = z3;
                            }
                        }
                        i5 = i2;
                        j2 = j;
                        i4 = 0;
                    }
                    i5 = i3;
                    j2 = j;
                    i4 = 0;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(String str, List<iu8> list, int i, int i2, float f) throws IOException {
            MediaExtractor mediaExtractor;
            MediaCodec mediaCodec;
            File file;
            int andSelectVideoTrackIndex;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, list, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
                du8 du8Var = null;
                try {
                    file = new File(str);
                } catch (Exception e) {
                    e = e;
                    mediaExtractor = null;
                    mediaCodec = null;
                } catch (Throwable th) {
                    th = th;
                    mediaExtractor = null;
                    mediaCodec = null;
                }
                if (file.canRead()) {
                    mediaExtractor = new MediaExtractor();
                    try {
                        mediaExtractor.setDataSource(file.toString());
                        andSelectVideoTrackIndex = MediaCodecHelper.getAndSelectVideoTrackIndex(mediaExtractor);
                    } catch (Exception e2) {
                        e = e2;
                        mediaCodec = null;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaCodec = null;
                    }
                    if (andSelectVideoTrackIndex >= 0) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
                        int integer = trackFormat.getInteger("width");
                        int integer2 = trackFormat.getInteger("height");
                        if (i == 0 || i2 == 0) {
                            float f2 = f % 360.0f;
                            if (f2 != 90.0f && f2 != 270.0f) {
                                i = integer;
                                i2 = integer2;
                            }
                            i2 = integer;
                            i = integer2;
                        }
                        du8 du8Var2 = new du8(i, i2, true, null);
                        try {
                            du8Var2.a(integer, integer2, f);
                            mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                        } catch (Exception e3) {
                            e = e3;
                            mediaCodec = null;
                        } catch (Throwable th3) {
                            th = th3;
                            mediaCodec = null;
                        }
                        try {
                            mediaCodec.configure(trackFormat, du8Var2.getSurface(), (MediaCrypto) null, 0);
                            mediaCodec.start();
                            d(mediaExtractor, andSelectVideoTrackIndex, mediaCodec, du8Var2, list);
                            du8Var2.release();
                            if (mediaCodec != null) {
                                mediaCodec.stop();
                                mediaCodec.release();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            du8Var = du8Var2;
                            try {
                                p79.g(e);
                                if (du8Var != null) {
                                    du8Var.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor == null) {
                                    return;
                                }
                                mediaExtractor.release();
                                return;
                            } catch (Throwable th4) {
                                th = th4;
                                if (du8Var != null) {
                                    du8Var.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor != null) {
                                    mediaExtractor.release();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            du8Var = du8Var2;
                            if (du8Var != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (mediaExtractor != null) {
                            }
                            throw th;
                        }
                        mediaExtractor.release();
                        return;
                    }
                    throw new RuntimeException("No video track found in " + file);
                }
                throw new FileNotFoundException("Unable to read " + file);
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c && !j89.a(this.b) : invokeV.booleanValue;
        }

        public void h(ou8 ou8Var, nu8 nu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, ou8Var, nu8Var) == null) {
                if (ou8Var != null && !u79.e(ou8Var.e)) {
                    this.d = true;
                    ThreadPool.b().e(new a(this, ou8Var, nu8Var));
                    return;
                }
                k(nu8Var);
            }
        }

        public final void i(ou8 ou8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ou8Var) == null) {
                try {
                    e(ou8Var.a, ou8Var.e, ou8Var.c, ou8Var.d, ou8Var.b);
                } catch (Exception e) {
                    e.printStackTrace();
                    j(ou8Var);
                }
            }
        }

        public final void j(ou8 ou8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ou8Var) == null) {
                try {
                    for (iu8 iu8Var : ou8Var.e) {
                        Bitmap frameAtTime = getFrameAtTime(iu8Var.d, 2);
                        if (frameAtTime != null) {
                            if (ou8Var.c != 0 && ou8Var.d != 0) {
                                iu8Var.e = ThumbnailUtils.extractThumbnail(frameAtTime, ou8Var.c, ou8Var.d, 2);
                            }
                            iu8Var.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public final void k(nu8 nu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nu8Var) == null) {
                this.d = false;
                h89.a().post(new RunnableC0428b(this, nu8Var));
            }
        }

        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.d = z;
            }
        }

        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.c = z;
            }
        }

        @Override // android.media.MediaMetadataRetriever
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                super.release();
                this.a = true;
                this.d = false;
            }
        }

        @Override // android.media.MediaMetadataRetriever
        public void setDataSource(String str) throws IllegalArgumentException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                try {
                    super.setDataSource(str);
                    this.b = str;
                } catch (Exception e) {
                    p79.g(e);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = true;
        }
    }

    public fu8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new b(null));
        this.a.add(new b(null));
    }

    public static fu8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (fu8.class) {
                    if (b == null) {
                        b = new fu8();
                    }
                }
            }
            return b;
        }
        return (fu8) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        r2.l(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized b b() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                bVar = null;
                Iterator<b> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (next != null && !next.f()) {
                        break;
                    }
                }
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.l(false);
    }
}
