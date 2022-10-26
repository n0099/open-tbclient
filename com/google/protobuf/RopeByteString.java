package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
/* loaded from: classes7.dex */
public class RopeByteString extends ByteString {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] minLengthByDepth;
    public transient /* synthetic */ FieldHolder $fh;
    public int hash;
    public final ByteString left;
    public final int leftLength;
    public final ByteString right;
    public final int totalLength;
    public final int treeDepth;

    /* renamed from: com.google.protobuf.RopeByteString$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class Balancer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Stack prefixesStack;

        public Balancer() {
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
            this.prefixesStack = new Stack();
        }

        public /* synthetic */ Balancer(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int getDepthBinForLength(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
                int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i);
                if (binarySearch < 0) {
                    return (-(binarySearch + 1)) - 1;
                }
                return binarySearch;
            }
            return invokeI.intValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, byteString, byteString2)) == null) {
                doBalance(byteString);
                doBalance(byteString2);
                ByteString byteString3 = (ByteString) this.prefixesStack.pop();
                while (!this.prefixesStack.isEmpty()) {
                    byteString3 = new RopeByteString((ByteString) this.prefixesStack.pop(), byteString3, null);
                }
                return byteString3;
            }
            return (ByteString) invokeLL.objValue;
        }

        private void doBalance(ByteString byteString) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, byteString) == null) {
                if (byteString.isBalanced()) {
                    insert(byteString);
                } else if (byteString instanceof RopeByteString) {
                    RopeByteString ropeByteString = (RopeByteString) byteString;
                    doBalance(ropeByteString.left);
                    doBalance(ropeByteString.right);
                } else {
                    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
                }
            }
        }

        private void insert(ByteString byteString) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, byteString) == null) {
                int depthBinForLength = getDepthBinForLength(byteString.size());
                int i = RopeByteString.minLengthByDepth[depthBinForLength + 1];
                if (!this.prefixesStack.isEmpty() && ((ByteString) this.prefixesStack.peek()).size() < i) {
                    int i2 = RopeByteString.minLengthByDepth[depthBinForLength];
                    ByteString byteString2 = (ByteString) this.prefixesStack.pop();
                    while (!this.prefixesStack.isEmpty() && ((ByteString) this.prefixesStack.peek()).size() < i2) {
                        byteString2 = new RopeByteString((ByteString) this.prefixesStack.pop(), byteString2, null);
                    }
                    RopeByteString ropeByteString = new RopeByteString(byteString2, byteString, null);
                    while (!this.prefixesStack.isEmpty()) {
                        if (((ByteString) this.prefixesStack.peek()).size() >= RopeByteString.minLengthByDepth[getDepthBinForLength(ropeByteString.size()) + 1]) {
                            break;
                        }
                        ropeByteString = new RopeByteString((ByteString) this.prefixesStack.pop(), ropeByteString, null);
                    }
                    this.prefixesStack.push(ropeByteString);
                    return;
                }
                this.prefixesStack.push(byteString);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class PieceIterator implements Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Stack breadCrumbs;
        public LiteralByteString next;

        public PieceIterator(ByteString byteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.breadCrumbs = new Stack();
            this.next = getLeafByLeft(byteString);
        }

        public /* synthetic */ PieceIterator(ByteString byteString, AnonymousClass1 anonymousClass1) {
            this(byteString);
        }

        private LiteralByteString getLeafByLeft(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, byteString)) == null) {
                while (byteString instanceof RopeByteString) {
                    RopeByteString ropeByteString = (RopeByteString) byteString;
                    this.breadCrumbs.push(ropeByteString);
                    byteString = ropeByteString.left;
                }
                return (LiteralByteString) byteString;
            }
            return (LiteralByteString) invokeL.objValue;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                while (!this.breadCrumbs.isEmpty()) {
                    LiteralByteString leafByLeft = getLeafByLeft(((RopeByteString) this.breadCrumbs.pop()).right);
                    if (!leafByLeft.isEmpty()) {
                        return leafByLeft;
                    }
                }
                return null;
            }
            return (LiteralByteString) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.next != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public LiteralByteString next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                LiteralByteString literalByteString = this.next;
                if (literalByteString != null) {
                    this.next = getNextNonEmptyLeaf();
                    return literalByteString;
                }
                throw new NoSuchElementException();
            }
            return (LiteralByteString) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class RopeByteIterator implements ByteString.ByteIterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteString.ByteIterator bytes;
        public int bytesRemaining;
        public final PieceIterator pieces;
        public final /* synthetic */ RopeByteString this$0;

        public RopeByteIterator(RopeByteString ropeByteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ropeByteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = ropeByteString;
            PieceIterator pieceIterator = new PieceIterator(ropeByteString, null);
            this.pieces = pieceIterator;
            this.bytes = pieceIterator.next().iterator();
            this.bytesRemaining = ropeByteString.size();
        }

        public /* synthetic */ RopeByteIterator(RopeByteString ropeByteString, AnonymousClass1 anonymousClass1) {
            this(ropeByteString);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.bytesRemaining > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Byte next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return Byte.valueOf(nextByte());
            }
            return (Byte) invokeV.objValue;
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!this.bytes.hasNext()) {
                    this.bytes = this.pieces.next().iterator();
                }
                this.bytesRemaining--;
                return this.bytes.nextByte();
            }
            return invokeV.byteValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class RopeInputStream extends InputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LiteralByteString currentPiece;
        public int currentPieceIndex;
        public int currentPieceOffsetInRope;
        public int currentPieceSize;
        public int mark;
        public PieceIterator pieceIterator;
        public final /* synthetic */ RopeByteString this$0;

        @Override // java.io.InputStream
        public boolean markSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public RopeInputStream(RopeByteString ropeByteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ropeByteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = ropeByteString;
            initialize();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (j >= 0) {
                    if (j > 2147483647L) {
                        j = 2147483647L;
                    }
                    return readSkipInternal(null, 0, (int) j);
                }
                throw new IndexOutOfBoundsException();
            }
            return invokeJ.longValue;
        }

        private void advanceIfCurrentPieceFullyRead() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.currentPiece != null) {
                int i = this.currentPieceIndex;
                int i2 = this.currentPieceSize;
                if (i == i2) {
                    this.currentPieceOffsetInRope += i2;
                    this.currentPieceIndex = 0;
                    if (this.pieceIterator.hasNext()) {
                        LiteralByteString next = this.pieceIterator.next();
                        this.currentPiece = next;
                        this.currentPieceSize = next.size();
                        return;
                    }
                    this.currentPiece = null;
                    this.currentPieceSize = 0;
                }
            }
        }

        private void initialize() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                PieceIterator pieceIterator = new PieceIterator(this.this$0, null);
                this.pieceIterator = pieceIterator;
                LiteralByteString next = pieceIterator.next();
                this.currentPiece = next;
                this.currentPieceSize = next.size();
                this.currentPieceIndex = 0;
                this.currentPieceOffsetInRope = 0;
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.this$0.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                advanceIfCurrentPieceFullyRead();
                LiteralByteString literalByteString = this.currentPiece;
                if (literalByteString == null) {
                    return -1;
                }
                int i = this.currentPieceIndex;
                this.currentPieceIndex = i + 1;
                return literalByteString.byteAt(i) & 255;
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (this) {
                    initialize();
                    readSkipInternal(null, 0, this.mark);
                }
            }
        }

        private int readSkipInternal(byte[] bArr, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, this, bArr, i, i2)) == null) {
                int i3 = i2;
                while (true) {
                    if (i3 <= 0) {
                        break;
                    }
                    advanceIfCurrentPieceFullyRead();
                    if (this.currentPiece == null) {
                        if (i3 == i2) {
                            return -1;
                        }
                    } else {
                        int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i3);
                        if (bArr != null) {
                            this.currentPiece.copyTo(bArr, this.currentPieceIndex, i, min);
                            i += min;
                        }
                        this.currentPieceIndex += min;
                        i3 -= min;
                    }
                }
                return i2 - i3;
            }
            return invokeLII.intValue;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
                if (bArr != null) {
                    if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                        return readSkipInternal(bArr, i, i2);
                    }
                    throw new IndexOutOfBoundsException();
                }
                throw null;
            }
            return invokeLII.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(53469160, "Lcom/google/protobuf/RopeByteString;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(53469160, "Lcom/google/protobuf/RopeByteString;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i4 < iArr.length) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                i4++;
            } else {
                return;
            }
        }
    }

    public RopeByteString(ByteString byteString, ByteString byteString2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteString, byteString2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hash = 0;
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, AnonymousClass1 anonymousClass1) {
        this(byteString, byteString2);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            this.left.copyTo(byteBuffer);
            this.right.copyTo(byteBuffer);
        }
    }

    @Override // com.google.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            return new String(toByteArray(), str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, outputStream) == null) {
            this.left.writeTo(outputStream);
            this.right.writeTo(outputStream);
        }
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public List asReadOnlyByteBufferList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            PieceIterator pieceIterator = new PieceIterator(this, null);
            while (pieceIterator.hasNext()) {
                arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.treeDepth;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.hash;
            if (i == 0) {
                int i2 = this.totalLength;
                i = partialHash(i2, 0, i2);
                if (i == 0) {
                    i = 1;
                }
                this.hash = i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.totalLength >= minLengthByDepth[this.treeDepth]) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
            ByteString byteString = this.right;
            if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    public ByteString.ByteIterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new RopeByteIterator(this, null);
        }
        return (ByteString.ByteIterator) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return CodedInputStream.newInstance(new RopeInputStream(this));
        }
        return (CodedInputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new RopeInputStream(this);
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public int peekCachedHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.hash;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.totalLength;
        }
        return invokeV.intValue;
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        InterceptResult invokeLL;
        RopeByteString ropeByteString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, byteString, byteString2)) == null) {
            if (byteString instanceof RopeByteString) {
                ropeByteString = (RopeByteString) byteString;
            } else {
                ropeByteString = null;
            }
            if (byteString2.size() != 0) {
                if (byteString.size() != 0) {
                    int size = byteString.size() + byteString2.size();
                    if (size < 128) {
                        return concatenateBytes(byteString, byteString2);
                    }
                    if (ropeByteString != null && ropeByteString.right.size() + byteString2.size() < 128) {
                        byteString2 = new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
                    } else if (ropeByteString != null && ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                        byteString2 = new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
                    } else if (size < minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1]) {
                        return new Balancer(null).balance(byteString, byteString2);
                    } else {
                        return new RopeByteString(byteString, byteString2);
                    }
                }
                return byteString2;
            }
            return byteString;
        }
        return (ByteString) invokeLL.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i, i2)) == null) {
            if (i >= 0) {
                int i3 = this.totalLength;
                if (i2 <= i3) {
                    int i4 = i2 - i;
                    if (i4 >= 0) {
                        if (i4 == 0) {
                            return ByteString.EMPTY;
                        }
                        if (i4 == i3) {
                            return this;
                        }
                        int i5 = this.leftLength;
                        if (i2 <= i5) {
                            return this.left.substring(i, i2);
                        }
                        if (i >= i5) {
                            return this.right.substring(i - i5, i2 - i5);
                        }
                        return new RopeByteString(this.left.substring(i), this.right.substring(0, i2 - this.leftLength));
                    }
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
                }
                throw new IndexOutOfBoundsException("End index: " + i2 + " > " + this.totalLength);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        return (ByteString) invokeII.objValue;
    }

    public static LiteralByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, byteString, byteString2)) == null) {
            int size = byteString.size();
            int size2 = byteString2.size();
            byte[] bArr = new byte[size + size2];
            byteString.copyTo(bArr, 0, 0, size);
            byteString2.copyTo(bArr, 0, size, size2);
            return new LiteralByteString(bArr);
        }
        return (LiteralByteString) invokeLL.objValue;
    }

    public static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, byteString, byteString2)) == null) {
            return new RopeByteString(byteString, byteString2);
        }
        return (RopeByteString) invokeLL.objValue;
    }

    private boolean equalsFragments(ByteString byteString) {
        InterceptResult invokeL;
        boolean equalsRange;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, byteString)) == null) {
            PieceIterator pieceIterator = new PieceIterator(this, null);
            LiteralByteString literalByteString = (LiteralByteString) pieceIterator.next();
            PieceIterator pieceIterator2 = new PieceIterator(byteString, null);
            LiteralByteString literalByteString2 = (LiteralByteString) pieceIterator2.next();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int size = literalByteString.size() - i;
                int size2 = literalByteString2.size() - i2;
                int min = Math.min(size, size2);
                if (i == 0) {
                    equalsRange = literalByteString.equalsRange(literalByteString2, i2, min);
                } else {
                    equalsRange = literalByteString2.equalsRange(literalByteString, i, min);
                }
                if (!equalsRange) {
                    return false;
                }
                i3 += min;
                int i4 = this.totalLength;
                if (i3 >= i4) {
                    if (i3 == i4) {
                        return true;
                    }
                    throw new IllegalStateException();
                }
                if (min == size) {
                    literalByteString = (LiteralByteString) pieceIterator.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    literalByteString2 = (LiteralByteString) pieceIterator2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i >= 0) {
                if (i <= this.totalLength) {
                    int i2 = this.leftLength;
                    if (i < i2) {
                        return this.left.byteAt(i);
                    }
                    return this.right.byteAt(i - i2);
                }
                throw new ArrayIndexOutOfBoundsException("Index > length: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.totalLength);
            }
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        return invokeI.byteValue;
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, bArr, i, i2, i3) == null) {
            int i4 = i + i3;
            int i5 = this.leftLength;
            if (i4 <= i5) {
                this.left.copyToInternal(bArr, i, i2, i3);
            } else if (i >= i5) {
                this.right.copyToInternal(bArr, i - i5, i2, i3);
            } else {
                int i6 = i5 - i;
                this.left.copyToInternal(bArr, i, i2, i6);
                this.right.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
            }
        }
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int peekCachedHashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString)) {
                return false;
            }
            ByteString byteString = (ByteString) obj;
            if (this.totalLength != byteString.size()) {
                return false;
            }
            if (this.totalLength == 0) {
                return true;
            }
            if (this.hash != 0 && (peekCachedHashCode = byteString.peekCachedHashCode()) != 0 && this.hash != peekCachedHashCode) {
                return false;
            }
            return equalsFragments(byteString);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048590, this, i, i2, i3)) == null) {
            int i4 = i2 + i3;
            int i5 = this.leftLength;
            if (i4 <= i5) {
                return this.left.partialHash(i, i2, i3);
            }
            if (i2 >= i5) {
                return this.right.partialHash(i, i2 - i5, i3);
            }
            int i6 = i5 - i2;
            return this.right.partialHash(this.left.partialHash(i, i2, i6), 0, i3 - i6);
        }
        return invokeIII.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048591, this, i, i2, i3)) == null) {
            int i4 = i2 + i3;
            int i5 = this.leftLength;
            if (i4 <= i5) {
                return this.left.partialIsValidUtf8(i, i2, i3);
            }
            if (i2 >= i5) {
                return this.right.partialIsValidUtf8(i, i2 - i5, i3);
            }
            int i6 = i5 - i2;
            return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
        }
        return invokeIII.intValue;
    }
}
