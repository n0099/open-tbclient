package com.coremedia.iso;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public abstract class AbstractBoxParser implements BoxParser {
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadLocal<ByteBuffer> header;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2007516705, "Lcom/coremedia/iso/AbstractBoxParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2007516705, "Lcom/coremedia/iso/AbstractBoxParser;");
                return;
            }
        }
        LOG = Logger.getLogger(AbstractBoxParser.class.getName());
    }

    public AbstractBoxParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.header = new ThreadLocal<ByteBuffer>(this) { // from class: com.coremedia.iso.AbstractBoxParser.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AbstractBoxParser this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            public ByteBuffer initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ByteBuffer.allocate(32) : (ByteBuffer) invokeV.objValue;
            }
        };
    }

    public abstract Box createBox(String str, byte[] bArr, String str2);

    @Override // com.coremedia.iso.BoxParser
    public Box parseBox(DataSource dataSource, Container container) throws IOException {
        InterceptResult invokeLL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource, container)) == null) {
            this.header.get().rewind().limit(8);
            int i2 = 0;
            do {
                i2 += dataSource.read(this.header.get());
                if (i2 == 8) {
                    this.header.get().rewind();
                    long readUInt32 = IsoTypeReader.readUInt32(this.header.get());
                    byte[] bArr = null;
                    if (readUInt32 < 8 && readUInt32 > 1) {
                        Logger logger = LOG;
                        logger.severe("Plausibility check failed: size < 8 (size = " + readUInt32 + "). Stop parsing!");
                        return null;
                    }
                    String read4cc = IsoTypeReader.read4cc(this.header.get());
                    if (readUInt32 == 1) {
                        this.header.get().limit(16);
                        dataSource.read(this.header.get());
                        this.header.get().position(8);
                        j2 = IsoTypeReader.readUInt64(this.header.get()) - 16;
                    } else if (readUInt32 == 0) {
                        dataSource.size();
                        dataSource.position();
                        StringBuilder sb = new StringBuilder("'");
                        sb.append(read4cc);
                        sb.append("' with '");
                        sb.append(container instanceof Box ? ((Box) container).getType() : "IsoFile");
                        sb.append("' as parent has length == 0. That's not supported");
                        throw new RuntimeException(sb.toString());
                    } else {
                        j2 = readUInt32 - 8;
                    }
                    if ("uuid".equals(read4cc)) {
                        this.header.get().limit(this.header.get().limit() + 16);
                        dataSource.read(this.header.get());
                        byte[] bArr2 = new byte[16];
                        for (int position = this.header.get().position() - 16; position < this.header.get().position(); position++) {
                            bArr2[position - (this.header.get().position() - 16)] = this.header.get().get(position);
                        }
                        j3 = j2 - 16;
                        bArr = bArr2;
                    } else {
                        j3 = j2;
                    }
                    Box createBox = createBox(read4cc, bArr, container instanceof Box ? ((Box) container).getType() : "");
                    createBox.setParent(container);
                    this.header.get().rewind();
                    createBox.parse(dataSource, this.header.get(), j3, this);
                    return createBox;
                }
            } while (i2 >= 0);
            throw new EOFException();
        }
        return (Box) invokeLL.objValue;
    }
}
