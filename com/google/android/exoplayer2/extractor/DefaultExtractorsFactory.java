package com.google.android.exoplayer2.extractor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final Constructor<? extends Extractor> FLAC_EXTRACTOR_CONSTRUCTOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int fragmentedMp4Flags;
    public int matroskaFlags;
    public int mp3Flags;
    public int mp4Flags;
    public int tsFlags;
    public int tsMode;

    static {
        Constructor<? extends Extractor> constructor;
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(863795288, "Lcom/google/android/exoplayer2/extractor/DefaultExtractorsFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(863795288, "Lcom/google/android/exoplayer2/extractor/DefaultExtractorsFactory;");
                return;
            }
        }
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        FLAC_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    public DefaultExtractorsFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tsMode = 1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors() {
        InterceptResult invokeV;
        Extractor[] extractorArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                extractorArr = new Extractor[FLAC_EXTRACTOR_CONSTRUCTOR == null ? 11 : 12];
                extractorArr[0] = new MatroskaExtractor(this.matroskaFlags);
                extractorArr[1] = new FragmentedMp4Extractor(this.fragmentedMp4Flags);
                extractorArr[2] = new Mp4Extractor(this.mp4Flags);
                extractorArr[3] = new Mp3Extractor(this.mp3Flags);
                extractorArr[4] = new AdtsExtractor();
                extractorArr[5] = new Ac3Extractor();
                extractorArr[6] = new TsExtractor(this.tsMode, this.tsFlags);
                extractorArr[7] = new FlvExtractor();
                extractorArr[8] = new OggExtractor();
                extractorArr[9] = new PsExtractor();
                extractorArr[10] = new WavExtractor();
                if (FLAC_EXTRACTOR_CONSTRUCTOR != null) {
                    try {
                        extractorArr[11] = FLAC_EXTRACTOR_CONSTRUCTOR.newInstance(new Object[0]);
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
            }
            return extractorArr;
        }
        return (Extractor[]) invokeV.objValue;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            synchronized (this) {
                this.fragmentedMp4Flags = i;
            }
            return this;
        }
        return (DefaultExtractorsFactory) invokeI.objValue;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            synchronized (this) {
                this.matroskaFlags = i;
            }
            return this;
        }
        return (DefaultExtractorsFactory) invokeI.objValue;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            synchronized (this) {
                this.mp3Flags = i;
            }
            return this;
        }
        return (DefaultExtractorsFactory) invokeI.objValue;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                this.mp4Flags = i;
            }
            return this;
        }
        return (DefaultExtractorsFactory) invokeI.objValue;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            synchronized (this) {
                this.tsFlags = i;
            }
            return this;
        }
        return (DefaultExtractorsFactory) invokeI.objValue;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this) {
                this.tsMode = i;
            }
            return this;
        }
        return (DefaultExtractorsFactory) invokeI.objValue;
    }
}
