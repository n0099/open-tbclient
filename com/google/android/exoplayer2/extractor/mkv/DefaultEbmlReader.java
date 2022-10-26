package com.google.android.exoplayer2.extractor.mkv;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes7.dex */
public final class DefaultEbmlReader implements EbmlReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ELEMENT_STATE_READ_CONTENT = 2;
    public static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    public static final int ELEMENT_STATE_READ_ID = 0;
    public static final int MAX_ID_BYTES = 4;
    public static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    public static final int MAX_LENGTH_BYTES = 8;
    public static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    public static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public long elementContentSize;
    public int elementId;
    public int elementState;
    public final Stack masterElementsStack;
    public EbmlReaderOutput output;
    public final byte[] scratch;
    public final VarintReader varintReader;

    /* renamed from: com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class MasterElement {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long elementEndPosition;
        public final int elementId;

        public MasterElement(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.elementId = i;
            this.elementEndPosition = j;
        }

        public /* synthetic */ MasterElement(int i, long j, AnonymousClass1 anonymousClass1) {
            this(i, j);
        }
    }

    public DefaultEbmlReader() {
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
        this.scratch = new byte[8];
        this.masterElementsStack = new Stack();
        this.varintReader = new VarintReader();
    }

    private long maybeResyncToNextLevel1Element(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, extractorInput)) == null) {
            extractorInput.resetPeekPosition();
            while (true) {
                extractorInput.peekFully(this.scratch, 0, 4);
                int parseUnsignedVarintLength = VarintReader.parseUnsignedVarintLength(this.scratch[0]);
                if (parseUnsignedVarintLength != -1 && parseUnsignedVarintLength <= 4) {
                    int assembleVarint = (int) VarintReader.assembleVarint(this.scratch, parseUnsignedVarintLength, false);
                    if (this.output.isLevel1Element(assembleVarint)) {
                        extractorInput.skipFully(parseUnsignedVarintLength);
                        return assembleVarint;
                    }
                }
                extractorInput.skipFully(1);
            }
        } else {
            return invokeL.longValue;
        }
    }

    private double readFloat(ExtractorInput extractorInput, int i) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, extractorInput, i)) == null) {
            long readInteger = readInteger(extractorInput, i);
            if (i == 4) {
                return Float.intBitsToFloat((int) readInteger);
            }
            return Double.longBitsToDouble(readInteger);
        }
        return invokeLI.doubleValue;
    }

    private long readInteger(ExtractorInput extractorInput, int i) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, extractorInput, i)) == null) {
            extractorInput.readFully(this.scratch, 0, i);
            long j = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j << 8) | (this.scratch[i2] & 255);
            }
            return j;
        }
        return invokeLI.longValue;
    }

    private String readString(ExtractorInput extractorInput, int i) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, extractorInput, i)) == null) {
            if (i == 0) {
                return "";
            }
            byte[] bArr = new byte[i];
            extractorInput.readFully(bArr, 0, i);
            return new String(bArr);
        }
        return (String) invokeLI.objValue;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void init(EbmlReaderOutput ebmlReaderOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ebmlReaderOutput) == null) {
            this.output = ebmlReaderOutput;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public boolean read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extractorInput)) == null) {
            if (this.output != null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            while (true) {
                if (!this.masterElementsStack.isEmpty() && extractorInput.getPosition() >= ((MasterElement) this.masterElementsStack.peek()).elementEndPosition) {
                    this.output.endMasterElement(((MasterElement) this.masterElementsStack.pop()).elementId);
                    return true;
                }
                if (this.elementState == 0) {
                    long readUnsignedVarint = this.varintReader.readUnsignedVarint(extractorInput, true, false, 4);
                    if (readUnsignedVarint == -2) {
                        readUnsignedVarint = maybeResyncToNextLevel1Element(extractorInput);
                    }
                    if (readUnsignedVarint == -1) {
                        return false;
                    }
                    this.elementId = (int) readUnsignedVarint;
                    this.elementState = 1;
                }
                if (this.elementState == 1) {
                    this.elementContentSize = this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
                    this.elementState = 2;
                }
                int elementType = this.output.getElementType(this.elementId);
                if (elementType != 0) {
                    if (elementType != 1) {
                        if (elementType != 2) {
                            if (elementType != 3) {
                                if (elementType != 4) {
                                    if (elementType == 5) {
                                        long j = this.elementContentSize;
                                        if (j != 4 && j != 8) {
                                            throw new ParserException("Invalid float size: " + this.elementContentSize);
                                        }
                                        this.output.floatElement(this.elementId, readFloat(extractorInput, (int) this.elementContentSize));
                                        this.elementState = 0;
                                        return true;
                                    }
                                    throw new ParserException("Invalid element type " + elementType);
                                }
                                this.output.binaryElement(this.elementId, (int) this.elementContentSize, extractorInput);
                                this.elementState = 0;
                                return true;
                            }
                            long j2 = this.elementContentSize;
                            if (j2 <= 2147483647L) {
                                this.output.stringElement(this.elementId, readString(extractorInput, (int) j2));
                                this.elementState = 0;
                                return true;
                            }
                            throw new ParserException("String element size: " + this.elementContentSize);
                        }
                        long j3 = this.elementContentSize;
                        if (j3 <= 8) {
                            this.output.integerElement(this.elementId, readInteger(extractorInput, (int) j3));
                            this.elementState = 0;
                            return true;
                        }
                        throw new ParserException("Invalid integer size: " + this.elementContentSize);
                    }
                    long position = extractorInput.getPosition();
                    this.masterElementsStack.add(new MasterElement(this.elementId, this.elementContentSize + position, null));
                    this.output.startMasterElement(this.elementId, position, this.elementContentSize);
                    this.elementState = 0;
                    return true;
                }
                extractorInput.skipFully((int) this.elementContentSize);
                this.elementState = 0;
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.elementState = 0;
            this.masterElementsStack.clear();
            this.varintReader.reset();
        }
    }
}
