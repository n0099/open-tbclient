package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class PieceIterator implements Iterator<LiteralByteString> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Stack<RopeByteString> breadCrumbs;
        public LiteralByteString next;

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
                    LiteralByteString leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.next != null : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public PieceIterator(ByteString byteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.breadCrumbs = new Stack<>();
            this.next = getLeafByLeft(byteString);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
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
    }

    /* loaded from: classes10.dex */
    public class RopeByteIterator implements ByteString.ByteIterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteString.ByteIterator bytes;
        public int bytesRemaining;
        public final PieceIterator pieces;
        public final /* synthetic */ RopeByteString this$0;

        public /* synthetic */ RopeByteIterator(RopeByteString ropeByteString, AnonymousClass1 anonymousClass1) {
            this(ropeByteString);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bytesRemaining > 0 : invokeV.booleanValue;
        }

        /* JADX WARN: Type inference failed for: r0v10, types: [com.google.protobuf.ByteString$ByteIterator] */
        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!this.bytes.hasNext()) {
                    this.bytes = this.pieces.next().iterator2();
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

        /* JADX WARN: Type inference failed for: r0v3, types: [com.google.protobuf.ByteString$ByteIterator] */
        public RopeByteIterator(RopeByteString ropeByteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ropeByteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = ropeByteString;
            PieceIterator pieceIterator = new PieceIterator(ropeByteString, null);
            this.pieces = pieceIterator;
            this.bytes = pieceIterator.next().iterator2();
            this.bytesRemaining = ropeByteString.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Byte.valueOf(nextByte()) : (Byte) invokeV.objValue;
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
        int i2 = 1;
        int i3 = 1;
        while (i2 > 0) {
            arrayList.add(Integer.valueOf(i2));
            int i4 = i3 + i2;
            i3 = i2;
            i2 = i4;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        int i5 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i5 >= iArr.length) {
                return;
            }
            iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
            i5++;
        }
    }

    public /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, AnonymousClass1 anonymousClass1) {
        this(byteString, byteString2);
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, byteString, byteString2)) == null) {
            RopeByteString ropeByteString = byteString instanceof RopeByteString ? (RopeByteString) byteString : null;
            if (byteString2.size() == 0) {
                return byteString;
            }
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
        return (ByteString) invokeLL.objValue;
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

    private boolean equalsFragments(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, this, byteString)) != null) {
            return invokeL.booleanValue;
        }
        PieceIterator pieceIterator = new PieceIterator(this, null);
        LiteralByteString next = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString, null);
        LiteralByteString next2 = pieceIterator2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int size = next.size() - i2;
            int size2 = next2.size() - i3;
            int min = Math.min(size, size2);
            if (!(i2 == 0 ? next.equalsRange(next2, i3, min) : next2.equalsRange(next, i2, min))) {
                return false;
            }
            i4 += min;
            int i5 = this.totalLength;
            if (i4 >= i5) {
                if (i4 == i5) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = pieceIterator.next();
                i2 = 0;
            } else {
                i2 += min;
            }
            if (min == size2) {
                next2 = pieceIterator2.next();
                i3 = 0;
            } else {
                i3 += min;
            }
        }
    }

    public static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, byteString, byteString2)) == null) ? new RopeByteString(byteString, byteString2) : (RopeByteString) invokeLL.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer() : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
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
    public byte byteAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 >= 0) {
                if (i2 <= this.totalLength) {
                    int i3 = this.leftLength;
                    if (i2 < i3) {
                        return this.left.byteAt(i2);
                    }
                    return this.right.byteAt(i2 - i3);
                }
                throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.totalLength);
            }
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
        }
        return invokeI.byteValue;
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
    public void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, bArr, i2, i3, i4) == null) {
            int i5 = i2 + i4;
            int i6 = this.leftLength;
            if (i5 <= i6) {
                this.left.copyToInternal(bArr, i2, i3, i4);
            } else if (i2 >= i6) {
                this.right.copyToInternal(bArr, i2 - i6, i3, i4);
            } else {
                int i7 = i6 - i2;
                this.left.copyToInternal(bArr, i2, i3, i7);
                this.right.copyToInternal(bArr, 0, i3 + i7, i4 - i7);
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
            if (obj instanceof ByteString) {
                ByteString byteString = (ByteString) obj;
                if (this.totalLength != byteString.size()) {
                    return false;
                }
                if (this.totalLength == 0) {
                    return true;
                }
                if (this.hash == 0 || (peekCachedHashCode = byteString.peekCachedHashCode()) == 0 || this.hash == peekCachedHashCode) {
                    return equalsFragments(byteString);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.treeDepth : invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.hash;
            if (i2 == 0) {
                int i3 = this.totalLength;
                i2 = partialHash(i3, 0, i3);
                if (i2 == 0) {
                    i2 = 1;
                }
                this.hash = i2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.totalLength >= minLengthByDepth[this.treeDepth] : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
            ByteString byteString = this.right;
            return byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? CodedInputStream.newInstance(new RopeInputStream(this)) : (CodedInputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new RopeInputStream(this) : (InputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048590, this, i2, i3, i4)) == null) {
            int i5 = i3 + i4;
            int i6 = this.leftLength;
            if (i5 <= i6) {
                return this.left.partialHash(i2, i3, i4);
            }
            if (i3 >= i6) {
                return this.right.partialHash(i2, i3 - i6, i4);
            }
            int i7 = i6 - i3;
            return this.right.partialHash(this.left.partialHash(i2, i3, i7), 0, i4 - i7);
        }
        return invokeIII.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048591, this, i2, i3, i4)) == null) {
            int i5 = i3 + i4;
            int i6 = this.leftLength;
            if (i5 <= i6) {
                return this.left.partialIsValidUtf8(i2, i3, i4);
            }
            if (i3 >= i6) {
                return this.right.partialIsValidUtf8(i2, i3 - i6, i4);
            }
            int i7 = i6 - i3;
            return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i2, i3, i7), 0, i4 - i7);
        }
        return invokeIII.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int peekCachedHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.hash : invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.totalLength : invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i2, i3)) == null) {
            if (i2 >= 0) {
                int i4 = this.totalLength;
                if (i3 > i4) {
                    throw new IndexOutOfBoundsException("End index: " + i3 + " > " + this.totalLength);
                }
                int i5 = i3 - i2;
                if (i5 < 0) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3);
                } else if (i5 == 0) {
                    return ByteString.EMPTY;
                } else {
                    if (i5 == i4) {
                        return this;
                    }
                    int i6 = this.leftLength;
                    if (i3 <= i6) {
                        return this.left.substring(i2, i3);
                    }
                    if (i2 >= i6) {
                        return this.right.substring(i2 - i6, i3 - i6);
                    }
                    return new RopeByteString(this.left.substring(i2), this.right.substring(0, i3 - this.leftLength));
                }
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        }
        return (ByteString) invokeII.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? new String(toByteArray(), str) : (String) invokeL.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, outputStream) == null) {
            this.left.writeTo(outputStream);
            this.right.writeTo(outputStream);
        }
    }

    /* loaded from: classes10.dex */
    public static class Balancer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Stack<ByteString> prefixesStack;

        public Balancer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.prefixesStack = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, byteString, byteString2)) == null) {
                doBalance(byteString);
                doBalance(byteString2);
                ByteString pop = this.prefixesStack.pop();
                while (!this.prefixesStack.isEmpty()) {
                    pop = new RopeByteString(this.prefixesStack.pop(), pop, null);
                }
                return pop;
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

        private int getDepthBinForLength(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
                int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i2);
                return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
            }
            return invokeI.intValue;
        }

        private void insert(ByteString byteString) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, byteString) == null) {
                int depthBinForLength = getDepthBinForLength(byteString.size());
                int i2 = RopeByteString.minLengthByDepth[depthBinForLength + 1];
                if (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < i2) {
                    int i3 = RopeByteString.minLengthByDepth[depthBinForLength];
                    ByteString pop = this.prefixesStack.pop();
                    while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < i3) {
                        pop = new RopeByteString(this.prefixesStack.pop(), pop, null);
                    }
                    RopeByteString ropeByteString = new RopeByteString(pop, byteString, null);
                    while (!this.prefixesStack.isEmpty()) {
                        if (this.prefixesStack.peek().size() >= RopeByteString.minLengthByDepth[getDepthBinForLength(ropeByteString.size()) + 1]) {
                            break;
                        }
                        ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString, null);
                    }
                    this.prefixesStack.push(ropeByteString);
                    return;
                }
                this.prefixesStack.push(byteString);
            }
        }

        public /* synthetic */ Balancer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public RopeByteString(ByteString byteString, ByteString byteString2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteString, byteString2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new RopeByteIterator(this, null) : (ByteString.ByteIterator) invokeV.objValue;
    }

    /* loaded from: classes10.dex */
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

        public RopeInputStream(RopeByteString ropeByteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ropeByteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = ropeByteString;
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.currentPiece == null) {
                return;
            }
            int i2 = this.currentPieceIndex;
            int i3 = this.currentPieceSize;
            if (i2 == i3) {
                this.currentPieceOffsetInRope += i3;
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

        private int readSkipInternal(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, this, bArr, i2, i3)) == null) {
                int i4 = i3;
                while (true) {
                    if (i4 <= 0) {
                        break;
                    }
                    advanceIfCurrentPieceFullyRead();
                    if (this.currentPiece != null) {
                        int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i4);
                        if (bArr != null) {
                            this.currentPiece.copyTo(bArr, this.currentPieceIndex, i2, min);
                            i2 += min;
                        }
                        this.currentPieceIndex += min;
                        i4 -= min;
                    } else if (i4 == i3) {
                        return -1;
                    }
                }
                return i3 - i4;
            }
            return invokeLII.intValue;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex) : invokeV.intValue;
        }

        @Override // java.io.InputStream
        public void mark(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
                if (bArr != null) {
                    if (i2 >= 0 && i3 >= 0 && i3 <= bArr.length - i2) {
                        return readSkipInternal(bArr, i2, i3);
                    }
                    throw new IndexOutOfBoundsException();
                }
                throw null;
            }
            return invokeLII.intValue;
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

        @Override // java.io.InputStream
        public long skip(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                if (j2 >= 0) {
                    if (j2 > 2147483647L) {
                        j2 = 2147483647L;
                    }
                    return readSkipInternal(null, 0, (int) j2);
                }
                throw new IndexOutOfBoundsException();
            }
            return invokeJ.longValue;
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
                int i2 = this.currentPieceIndex;
                this.currentPieceIndex = i2 + 1;
                return literalByteString.byteAt(i2) & 255;
            }
            return invokeV.intValue;
        }
    }
}
