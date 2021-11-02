package com.googlecode.mp4parser;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Logger;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes2.dex */
public abstract class AbstractBox implements Box {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer content;
    public long contentStartPosition;
    public DataSource dataSource;
    public ByteBuffer deadBytes;
    public boolean isParsed;
    public boolean isRead;
    public long memMapSize;
    public long offset;
    public Container parent;
    public String type;
    public byte[] userType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1076125504, "Lcom/googlecode/mp4parser/AbstractBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1076125504, "Lcom/googlecode/mp4parser/AbstractBox;");
                return;
            }
        }
        LOG = Logger.getLogger(AbstractBox.class);
    }

    public AbstractBox(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.memMapSize = -1L;
        this.deadBytes = null;
        this.type = str;
        this.isRead = true;
        this.isParsed = true;
    }

    private void getHeader(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, byteBuffer) == null) {
            if (isSmallBox()) {
                IsoTypeWriter.writeUInt32(byteBuffer, getSize());
                byteBuffer.put(IsoFile.fourCCtoBytes(getType()));
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, 1L);
                byteBuffer.put(IsoFile.fourCCtoBytes(getType()));
                IsoTypeWriter.writeUInt64(byteBuffer, getSize());
            }
            if ("uuid".equals(getType())) {
                byteBuffer.put(getUserType());
            }
        }
    }

    private boolean isSmallBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i2 = "uuid".equals(getType()) ? 24 : 8;
            if (!this.isRead) {
                return this.memMapSize + ((long) i2) < 4294967296L;
            } else if (!this.isParsed) {
                return ((long) (this.content.limit() + i2)) < 4294967296L;
            } else {
                long contentSize = getContentSize();
                ByteBuffer byteBuffer = this.deadBytes;
                return (contentSize + ((long) (byteBuffer != null ? byteBuffer.limit() : 0))) + ((long) i2) < 4294967296L;
            }
        }
        return invokeV.booleanValue;
    }

    private synchronized void readContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            synchronized (this) {
                if (!this.isRead) {
                    try {
                        Logger logger = LOG;
                        logger.logDebug("mem mapping " + getType());
                        this.content = this.dataSource.map(this.contentStartPosition, this.memMapSize);
                        this.isRead = true;
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
    }

    private boolean verify(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        ByteBuffer byteBuffer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, byteBuffer)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(getContentSize() + (this.deadBytes != null ? byteBuffer2.limit() : 0)));
            getContent(allocate);
            ByteBuffer byteBuffer3 = this.deadBytes;
            if (byteBuffer3 != null) {
                byteBuffer3.rewind();
                while (this.deadBytes.remaining() > 0) {
                    allocate.put(this.deadBytes);
                }
            }
            byteBuffer.rewind();
            allocate.rewind();
            if (byteBuffer.remaining() != allocate.remaining()) {
                System.err.print(String.valueOf(getType()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
                LOG.logError(String.valueOf(getType()) + ": remaining differs " + byteBuffer.remaining() + " vs. " + allocate.remaining());
                return false;
            }
            int position = byteBuffer.position();
            int limit = byteBuffer.limit() - 1;
            int limit2 = allocate.limit() - 1;
            while (limit >= position) {
                byte b2 = byteBuffer.get(limit);
                byte b3 = allocate.get(limit2);
                if (b2 != b3) {
                    LOG.logError(String.format("%s: buffers differ at %d: %2X/%2X", getType(), Integer.valueOf(limit), Byte.valueOf(b2), Byte.valueOf(b3)));
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byte[] bArr2 = new byte[allocate.remaining()];
                    byteBuffer.get(bArr);
                    allocate.get(bArr2);
                    System.err.println("original      : " + Hex.encodeHex(bArr, 4));
                    System.err.println("reconstructed : " + Hex.encodeHex(bArr2, 4));
                    return false;
                }
                limit--;
                limit2--;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public abstract void _parseDetails(ByteBuffer byteBuffer);

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writableByteChannel) == null) {
            if (this.isRead) {
                if (this.isParsed) {
                    ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(getSize()));
                    getHeader(allocate);
                    getContent(allocate);
                    ByteBuffer byteBuffer = this.deadBytes;
                    if (byteBuffer != null) {
                        byteBuffer.rewind();
                        while (this.deadBytes.remaining() > 0) {
                            allocate.put(this.deadBytes);
                        }
                    }
                    writableByteChannel.write((ByteBuffer) allocate.rewind());
                    return;
                }
                ByteBuffer allocate2 = ByteBuffer.allocate((isSmallBox() ? 8 : 16) + ("uuid".equals(getType()) ? 16 : 0));
                getHeader(allocate2);
                writableByteChannel.write((ByteBuffer) allocate2.rewind());
                writableByteChannel.write((ByteBuffer) this.content.position(0));
                return;
            }
            ByteBuffer allocate3 = ByteBuffer.allocate((isSmallBox() ? 8 : 16) + ("uuid".equals(getType()) ? 16 : 0));
            getHeader(allocate3);
            writableByteChannel.write((ByteBuffer) allocate3.rewind());
            this.dataSource.transferTo(this.contentStartPosition, this.memMapSize, writableByteChannel);
        }
    }

    public abstract void getContent(ByteBuffer byteBuffer);

    public abstract long getContentSize();

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.offset : invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public Container getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parent : (Container) invokeV.objValue;
    }

    @DoNotParseDetail
    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Path.createPath(this) : (String) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        InterceptResult invokeV;
        long j;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.isRead) {
                j = this.memMapSize;
            } else if (this.isParsed) {
                j = getContentSize();
            } else {
                ByteBuffer byteBuffer2 = this.content;
                j = byteBuffer2 != null ? byteBuffer2.limit() : 0;
            }
            return j + (j >= 4294967288L ? 8 : 0) + 8 + ("uuid".equals(getType()) ? 16 : 0) + (this.deadBytes != null ? byteBuffer.limit() : 0);
        }
        return invokeV.longValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.type : (String) invokeV.objValue;
    }

    @DoNotParseDetail
    public byte[] getUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.userType : (byte[]) invokeV.objValue;
    }

    public boolean isParsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isParsed : invokeV.booleanValue;
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{dataSource, byteBuffer, Long.valueOf(j), boxParser}) == null) {
            long position = dataSource.position();
            this.contentStartPosition = position;
            this.offset = position - byteBuffer.remaining();
            this.memMapSize = j;
            this.dataSource = dataSource;
            dataSource.position(dataSource.position() + j);
            this.isRead = false;
            this.isParsed = false;
        }
    }

    public final synchronized void parseDetails() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                readContent();
                Logger logger = LOG;
                logger.logDebug("parsing details of " + getType());
                if (this.content != null) {
                    ByteBuffer byteBuffer = this.content;
                    this.isParsed = true;
                    byteBuffer.rewind();
                    _parseDetails(byteBuffer);
                    if (byteBuffer.remaining() > 0) {
                        this.deadBytes = byteBuffer.slice();
                    }
                    this.content = null;
                }
            }
        }
    }

    public void setDeadBytes(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, byteBuffer) == null) {
            this.deadBytes = byteBuffer;
        }
    }

    @Override // com.coremedia.iso.boxes.Box
    @DoNotParseDetail
    public void setParent(Container container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, container) == null) {
            this.parent = container;
        }
    }

    public AbstractBox(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.memMapSize = -1L;
        this.deadBytes = null;
        this.type = str;
        this.userType = bArr;
        this.isRead = true;
        this.isParsed = true;
    }
}
