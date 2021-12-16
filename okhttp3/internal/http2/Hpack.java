package okhttp3.internal.http2;

import android.net.http.Headers;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
/* loaded from: classes4.dex */
public final class Hpack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    public static final int PREFIX_4_BITS = 15;
    public static final int PREFIX_5_BITS = 31;
    public static final int PREFIX_6_BITS = 63;
    public static final int PREFIX_7_BITS = 127;
    public static final Header[] STATIC_HEADER_TABLE;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class Reader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        public final List<Header> headerList;
        public final int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        public int nextHeaderIndex;
        public final BufferedSource source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Reader(int i2, Source source) {
            this(i2, i2, source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), source};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (Source) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private void adjustDynamicTableByteCount() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (i2 = this.maxDynamicTableByteCount) >= (i3 = this.dynamicTableByteCount)) {
                return;
            }
            if (i2 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i3 - i2);
            }
        }

        private void clearDynamicTable() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                Arrays.fill(this.dynamicTable, (Object) null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
            }
        }

        private int dynamicTableIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) ? this.nextHeaderIndex + 1 + i2 : invokeI.intValue;
        }

        private int evictToRecoverBytes(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.dynamicTable.length;
                    while (true) {
                        length--;
                        if (length < this.nextHeaderIndex || i2 <= 0) {
                            break;
                        }
                        Header[] headerArr = this.dynamicTable;
                        i2 -= headerArr[length].hpackSize;
                        this.dynamicTableByteCount -= headerArr[length].hpackSize;
                        this.headerCount--;
                        i3++;
                    }
                    Header[] headerArr2 = this.dynamicTable;
                    int i4 = this.nextHeaderIndex;
                    System.arraycopy(headerArr2, i4 + 1, headerArr2, i4 + 1 + i3, this.headerCount);
                    this.nextHeaderIndex += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        private ByteString getName(int i2) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i2)) == null) {
                if (isStaticHeader(i2)) {
                    return Hpack.STATIC_HEADER_TABLE[i2].name;
                }
                int dynamicTableIndex = dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length);
                if (dynamicTableIndex >= 0) {
                    Header[] headerArr = this.dynamicTable;
                    if (dynamicTableIndex < headerArr.length) {
                        return headerArr[dynamicTableIndex].name;
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
            return (ByteString) invokeI.objValue;
        }

        private void insertIntoDynamicTable(int i2, Header header) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65543, this, i2, header) == null) {
                this.headerList.add(header);
                int i3 = header.hpackSize;
                if (i2 != -1) {
                    i3 -= this.dynamicTable[dynamicTableIndex(i2)].hpackSize;
                }
                int i4 = this.maxDynamicTableByteCount;
                if (i3 > i4) {
                    clearDynamicTable();
                    return;
                }
                int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i3) - i4);
                if (i2 == -1) {
                    int i5 = this.headerCount + 1;
                    Header[] headerArr = this.dynamicTable;
                    if (i5 > headerArr.length) {
                        Header[] headerArr2 = new Header[headerArr.length * 2];
                        System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                        this.nextHeaderIndex = this.dynamicTable.length - 1;
                        this.dynamicTable = headerArr2;
                    }
                    int i6 = this.nextHeaderIndex;
                    this.nextHeaderIndex = i6 - 1;
                    this.dynamicTable[i6] = header;
                    this.headerCount++;
                } else {
                    this.dynamicTable[i2 + dynamicTableIndex(i2) + evictToRecoverBytes] = header;
                }
                this.dynamicTableByteCount += i3;
            }
        }

        private boolean isStaticHeader(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) ? i2 >= 0 && i2 <= Hpack.STATIC_HEADER_TABLE.length - 1 : invokeI.booleanValue;
        }

        private int readByte() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.source.readByte() & 255 : invokeV.intValue;
        }

        private void readIndexedHeader(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65546, this, i2) == null) {
                if (isStaticHeader(i2)) {
                    this.headerList.add(Hpack.STATIC_HEADER_TABLE[i2]);
                    return;
                }
                int dynamicTableIndex = dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length);
                if (dynamicTableIndex >= 0) {
                    Header[] headerArr = this.dynamicTable;
                    if (dynamicTableIndex < headerArr.length) {
                        this.headerList.add(headerArr[dynamicTableIndex]);
                        return;
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
                insertIntoDynamicTable(-1, new Header(getName(i2), readByteString()));
            }
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
            }
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65549, this, i2) == null) {
                this.headerList.add(new Header(getName(i2), readByteString()));
            }
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
            }
        }

        public List<Header> getAndResetHeaderList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.headerList);
                this.headerList.clear();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public int maxDynamicTableByteCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.maxDynamicTableByteCount : invokeV.intValue;
        }

        public ByteString readByteString() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int readByte = readByte();
                boolean z = (readByte & 128) == 128;
                int readInt = readInt(readByte, 127);
                if (z) {
                    return ByteString.of(Huffman.get().decode(this.source.readByteArray(readInt)));
                }
                return this.source.readByteString(readInt);
            }
            return (ByteString) invokeV.objValue;
        }

        public void readHeaders() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.source.exhausted()) {
                    int readByte = this.source.readByte() & 255;
                    if (readByte == 128) {
                        throw new IOException("index == 0");
                    }
                    if ((readByte & 128) == 128) {
                        readIndexedHeader(readInt(readByte, 127) - 1);
                    } else if (readByte == 64) {
                        readLiteralHeaderWithIncrementalIndexingNewName();
                    } else if ((readByte & 64) == 64) {
                        readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(readByte, 63) - 1);
                    } else if ((readByte & 32) == 32) {
                        int readInt = readInt(readByte, 31);
                        this.maxDynamicTableByteCount = readInt;
                        if (readInt >= 0 && readInt <= this.headerTableSizeSetting) {
                            adjustDynamicTableByteCount();
                        } else {
                            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                        }
                    } else if (readByte != 16 && readByte != 0) {
                        readLiteralHeaderWithoutIndexingIndexedName(readInt(readByte, 15) - 1);
                    } else {
                        readLiteralHeaderWithoutIndexingNewName();
                    }
                }
            }
        }

        public int readInt(int i2, int i3) throws IOException {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeII = interceptable.invokeII(1048580, this, i2, i3)) != null) {
                return invokeII.intValue;
            }
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i3 + (readByte << i5);
                }
                i3 += (readByte & 127) << i5;
                i5 += 7;
            }
        }

        public Reader(int i2, int i3, Source source) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), source};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.headerList = new ArrayList();
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i3;
            this.source = Okio.buffer(source);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Writer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        public static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        public transient /* synthetic */ FieldHolder $fh;
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        public int nextHeaderIndex;
        public final Buffer out;
        public int smallestHeaderTableSizeSetting;
        public final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(Buffer buffer) {
            this(4096, true, buffer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buffer};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (Buffer) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private void adjustDynamicTableByteCount() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (i2 = this.maxDynamicTableByteCount) >= (i3 = this.dynamicTableByteCount)) {
                return;
            }
            if (i2 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i3 - i2);
            }
        }

        private void clearDynamicTable() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                Arrays.fill(this.dynamicTable, (Object) null);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
            }
        }

        private int evictToRecoverBytes(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.dynamicTable.length;
                    while (true) {
                        length--;
                        if (length < this.nextHeaderIndex || i2 <= 0) {
                            break;
                        }
                        Header[] headerArr = this.dynamicTable;
                        i2 -= headerArr[length].hpackSize;
                        this.dynamicTableByteCount -= headerArr[length].hpackSize;
                        this.headerCount--;
                        i3++;
                    }
                    Header[] headerArr2 = this.dynamicTable;
                    int i4 = this.nextHeaderIndex;
                    System.arraycopy(headerArr2, i4 + 1, headerArr2, i4 + 1 + i3, this.headerCount);
                    Header[] headerArr3 = this.dynamicTable;
                    int i5 = this.nextHeaderIndex;
                    Arrays.fill(headerArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                    this.nextHeaderIndex += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        private void insertIntoDynamicTable(Header header) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, this, header) == null) {
                int i2 = header.hpackSize;
                int i3 = this.maxDynamicTableByteCount;
                if (i2 > i3) {
                    clearDynamicTable();
                    return;
                }
                evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
                this.dynamicTableByteCount += i2;
            }
        }

        public void setHeaderTableSizeSetting(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.headerTableSizeSetting = i2;
                int min = Math.min(i2, 16384);
                int i3 = this.maxDynamicTableByteCount;
                if (i3 == min) {
                    return;
                }
                if (min < i3) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        public void writeByteString(ByteString byteString) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteString) == null) {
                if (this.useCompression && Huffman.get().encodedLength(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    Huffman.get().encode(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    this.out.write(readByteString);
                    return;
                }
                writeInt(byteString.size(), 127, 0);
                this.out.write(byteString);
            }
        }

        public void writeHeaders(List<Header> list) throws IOException {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                if (this.emitDynamicTableSizeUpdate) {
                    int i4 = this.smallestHeaderTableSizeSetting;
                    if (i4 < this.maxDynamicTableByteCount) {
                        writeInt(i4, 31, 32);
                    }
                    this.emitDynamicTableSizeUpdate = false;
                    this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                    writeInt(this.maxDynamicTableByteCount, 31, 32);
                }
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Header header = list.get(i5);
                    ByteString asciiLowercase = header.name.toAsciiLowercase();
                    ByteString byteString = header.value;
                    Integer num = Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                    if (num != null) {
                        i2 = num.intValue() + 1;
                        if (i2 > 1 && i2 < 8) {
                            if (Util.equal(Hpack.STATIC_HEADER_TABLE[i2 - 1].value, byteString)) {
                                i3 = i2;
                            } else if (Util.equal(Hpack.STATIC_HEADER_TABLE[i2].value, byteString)) {
                                i3 = i2;
                                i2++;
                            }
                        }
                        i3 = i2;
                        i2 = -1;
                    } else {
                        i2 = -1;
                        i3 = -1;
                    }
                    if (i2 == -1) {
                        int i6 = this.nextHeaderIndex + 1;
                        int length = this.dynamicTable.length;
                        while (true) {
                            if (i6 >= length) {
                                break;
                            }
                            if (Util.equal(this.dynamicTable[i6].name, asciiLowercase)) {
                                if (Util.equal(this.dynamicTable[i6].value, byteString)) {
                                    i2 = Hpack.STATIC_HEADER_TABLE.length + (i6 - this.nextHeaderIndex);
                                    break;
                                } else if (i3 == -1) {
                                    i3 = (i6 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                                }
                            }
                            i6++;
                        }
                    }
                    if (i2 != -1) {
                        writeInt(i2, 127, 128);
                    } else if (i3 == -1) {
                        this.out.writeByte(64);
                        writeByteString(asciiLowercase);
                        writeByteString(byteString);
                        insertIntoDynamicTable(header);
                    } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX) && !Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                        writeInt(i3, 15, 0);
                        writeByteString(byteString);
                    } else {
                        writeInt(i3, 63, 64);
                        writeByteString(byteString);
                        insertIntoDynamicTable(header);
                    }
                }
            }
        }

        public void writeInt(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
                if (i2 < i3) {
                    this.out.writeByte(i2 | i4);
                    return;
                }
                this.out.writeByte(i4 | i3);
                int i5 = i2 - i3;
                while (i5 >= 128) {
                    this.out.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                this.out.writeByte(i5);
            }
        }

        public Writer(int i2, boolean z, Buffer buffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), buffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i2;
            this.useCompression = z;
            this.out = buffer;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1773912443, "Lokhttp3/internal/http2/Hpack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1773912443, "Lokhttp3/internal/http2/Hpack;");
                return;
            }
        }
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, BasicPushStatus.SUCCESS_CODE), new Header(Header.RESPONSE_STATUS, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204), new Header(Header.RESPONSE_STATUS, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, FontParser.sFontWeightDefault), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header(Headers.ACCEPT_RANGES, ""), new Header(BOSTokenRequest.ACCEPT, ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header(Headers.CACHE_CONTROL, ""), new Header(Headers.CONTENT_DISPOSITION, ""), new Header(Headers.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header(Headers.CONTENT_LEN, ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header(Headers.LAST_MODIFIED, ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header(Headers.PROXY_AUTHENTICATE, ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header(Headers.SET_COOKIE, ""), new Header("strict-transport-security", ""), new Header(Headers.TRANSFER_ENCODING, ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header(Headers.WWW_AUTHENTICATE, "")};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    public Hpack() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ByteString checkLowercase(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, byteString)) == null) {
            int size = byteString.size();
            for (int i2 = 0; i2 < size; i2++) {
                byte b2 = byteString.getByte(i2);
                if (b2 >= 65 && b2 <= 90) {
                    throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
                }
            }
            return byteString;
        }
        return (ByteString) invokeL.objValue;
    }

    public static Map<ByteString, Integer> nameToFirstIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return (Map) invokeV.objValue;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i2 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i2 < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[i2].name)) {
                    linkedHashMap.put(STATIC_HEADER_TABLE[i2].name, Integer.valueOf(i2));
                }
                i2++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}
