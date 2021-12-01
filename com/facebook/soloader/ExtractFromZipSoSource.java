package com.facebook.soloader;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ExtractFromZipSoSource extends UnpackingSoSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File mZipFileName;
    public final String mZipSearchPattern;

    /* renamed from: com.facebook.soloader.ExtractFromZipSoSource$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class ZipDso extends UnpackingSoSource.Dso implements Comparable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int abiScore;
        public final ZipEntry backingEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZipDso(String str, ZipEntry zipEntry, int i2) {
            super(str, makePseudoHash(zipEntry));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, zipEntry, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.backingEntry = zipEntry;
            this.abiScore = i2;
        }

        public static String makePseudoHash(ZipEntry zipEntry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zipEntry)) == null) ? String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())) : (String) invokeL.objValue;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.name.compareTo(((ZipDso) obj).name) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class ZipUnpacker extends UnpackingSoSource.Unpacker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ZipDso[] mDsos;
        public final UnpackingSoSource mSoSource;
        public final ZipFile mZipFile;
        public final /* synthetic */ ExtractFromZipSoSource this$0;

        /* loaded from: classes2.dex */
        public final class ZipBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mCurrentDso;
            public final /* synthetic */ ZipUnpacker this$1;

            public ZipBackedInputDsoIterator(ZipUnpacker zipUnpacker) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {zipUnpacker};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = zipUnpacker;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.this$1.ensureDsos();
                    return this.mCurrentDso < this.this$1.mDsos.length;
                }
                return invokeV.booleanValue;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    this.this$1.ensureDsos();
                    ZipDso[] zipDsoArr = this.this$1.mDsos;
                    int i2 = this.mCurrentDso;
                    this.mCurrentDso = i2 + 1;
                    ZipDso zipDso = zipDsoArr[i2];
                    InputStream inputStream = this.this$1.mZipFile.getInputStream(zipDso.backingEntry);
                    try {
                        return new UnpackingSoSource.InputDso(zipDso, inputStream);
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                }
                return (UnpackingSoSource.InputDso) invokeV.objValue;
            }

            public /* synthetic */ ZipBackedInputDsoIterator(ZipUnpacker zipUnpacker, AnonymousClass1 anonymousClass1) {
                this(zipUnpacker);
            }
        }

        public ZipUnpacker(ExtractFromZipSoSource extractFromZipSoSource, UnpackingSoSource unpackingSoSource) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extractFromZipSoSource, unpackingSoSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = extractFromZipSoSource;
            this.mZipFile = new ZipFile(extractFromZipSoSource.mZipFileName);
            this.mSoSource = unpackingSoSource;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mZipFile.close();
            }
        }

        public final ZipDso[] ensureDsos() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mDsos == null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    HashMap hashMap = new HashMap();
                    Pattern compile = Pattern.compile(this.this$0.mZipSearchPattern);
                    String[] supportedAbis = SysUtil.getSupportedAbis();
                    Enumeration<? extends ZipEntry> entries = this.mZipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        Matcher matcher = compile.matcher(nextElement.getName());
                        if (matcher.matches()) {
                            String group = matcher.group(1);
                            String group2 = matcher.group(2);
                            int findAbiScore = SysUtil.findAbiScore(supportedAbis, group);
                            if (findAbiScore >= 0) {
                                linkedHashSet.add(group);
                                ZipDso zipDso = (ZipDso) hashMap.get(group2);
                                if (zipDso == null || findAbiScore < zipDso.abiScore) {
                                    hashMap.put(group2, new ZipDso(group2, nextElement, findAbiScore));
                                }
                            }
                        }
                    }
                    this.mSoSource.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
                    ZipDso[] zipDsoArr = (ZipDso[]) hashMap.values().toArray(new ZipDso[hashMap.size()]);
                    Arrays.sort(zipDsoArr);
                    int i2 = 0;
                    for (int i3 = 0; i3 < zipDsoArr.length; i3++) {
                        ZipDso zipDso2 = zipDsoArr[i3];
                        if (shouldExtract(zipDso2.backingEntry, zipDso2.name)) {
                            i2++;
                        } else {
                            zipDsoArr[i3] = null;
                        }
                    }
                    ZipDso[] zipDsoArr2 = new ZipDso[i2];
                    int i4 = 0;
                    for (ZipDso zipDso3 : zipDsoArr) {
                        if (zipDso3 != null) {
                            zipDsoArr2[i4] = zipDso3;
                            i4++;
                        }
                    }
                    this.mDsos = zipDsoArr2;
                }
                return this.mDsos;
            }
            return (ZipDso[]) invokeV.objValue;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new UnpackingSoSource.DsoManifest(ensureDsos()) : (UnpackingSoSource.DsoManifest) invokeV.objValue;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new ZipBackedInputDsoIterator(this, null) : (UnpackingSoSource.InputDsoIterator) invokeV.objValue;
        }

        public boolean shouldExtract(ZipEntry zipEntry, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, zipEntry, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtractFromZipSoSource(Context context, String str, File file, String str2) {
        super(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, file, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mZipFileName = file;
        this.mZipSearchPattern = str2;
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ZipUnpacker(this, this) : (UnpackingSoSource.Unpacker) invokeV.objValue;
    }
}
