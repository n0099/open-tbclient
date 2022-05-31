package com.googlecode.mp4parser;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.util.LazyList;
import com.googlecode.mp4parser.util.Logger;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
public class BasicContainer implements Container, Iterator<Box> {
    public static /* synthetic */ Interceptable $ic;
    public static final Box EOF;
    public static Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;
    public BoxParser boxParser;
    public List<Box> boxes;
    public DataSource dataSource;
    public long endPosition;
    public Box lookahead;
    public long parsePosition;
    public long startPosition;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-766944326, "Lcom/googlecode/mp4parser/BasicContainer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-766944326, "Lcom/googlecode/mp4parser/BasicContainer;");
                return;
            }
        }
        LOG = Logger.getLogger(AbstractContainerBox.class);
        EOF = new AbstractBox("eof ") { // from class: com.googlecode.mp4parser.BasicContainer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r7};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.googlecode.mp4parser.AbstractBox
            public void _parseDetails(ByteBuffer byteBuffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, byteBuffer) == null) {
                }
            }

            @Override // com.googlecode.mp4parser.AbstractBox
            public void getContent(ByteBuffer byteBuffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                }
            }

            @Override // com.googlecode.mp4parser.AbstractBox
            public long getContentSize() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return 0L;
                }
                return invokeV.longValue;
            }
        };
    }

    public BasicContainer() {
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
        this.boxes = new ArrayList();
        this.lookahead = null;
        this.parsePosition = 0L;
        this.startPosition = 0L;
        this.endPosition = 0L;
    }

    public void addBox(Box box) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, box) == null) {
            this.boxes = new ArrayList(getBoxes());
            box.setParent(this);
            this.boxes.add(box);
        }
    }

    @Override // com.coremedia.iso.boxes.Container
    public List<Box> getBoxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.dataSource != null && this.lookahead != EOF) {
                return new LazyList(this.boxes, this);
            }
            return this.boxes;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Container
    public ByteBuffer getByteBuffer(long j, long j2) throws IOException {
        InterceptResult invokeCommon;
        ByteBuffer map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this.dataSource) {
                map = this.dataSource.map(this.startPosition + j, j2);
            }
            return map;
        }
        return (ByteBuffer) invokeCommon.objValue;
    }

    public long getContainerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j = 0;
            for (int i = 0; i < getBoxes().size(); i++) {
                j += this.boxes.get(i).getSize();
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Box box = this.lookahead;
            if (box == EOF) {
                return false;
            }
            if (box != null) {
                return true;
            }
            try {
                this.lookahead = next();
                return true;
            } catch (NoSuchElementException unused) {
                this.lookahead = EOF;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void parseContainer(DataSource dataSource, long j, BoxParser boxParser) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{dataSource, Long.valueOf(j), boxParser}) == null) {
            this.dataSource = dataSource;
            long position = dataSource.position();
            this.startPosition = position;
            this.parsePosition = position;
            dataSource.position(dataSource.position() + j);
            this.endPosition = dataSource.position();
            this.boxParser = boxParser;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.coremedia.iso.boxes.Container
    public void setBoxes(List<Box> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.boxes = new ArrayList(list);
            this.lookahead = EOF;
            this.dataSource = null;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (int i = 0; i < this.boxes.size(); i++) {
                if (i > 0) {
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
                sb.append(this.boxes.get(i).toString());
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Container
    public final void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, writableByteChannel) == null) {
            for (Box box : getBoxes()) {
                box.getBox(writableByteChannel);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Box next() {
        InterceptResult invokeV;
        Box parseBox;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Box box = this.lookahead;
            if (box != null && box != EOF) {
                this.lookahead = null;
                return box;
            }
            LOG.logDebug("Parsing next() box");
            DataSource dataSource = this.dataSource;
            if (dataSource != null && this.parsePosition < this.endPosition) {
                try {
                    synchronized (dataSource) {
                        this.dataSource.position(this.parsePosition);
                        parseBox = this.boxParser.parseBox(this.dataSource, this);
                        this.parsePosition = this.dataSource.position();
                    }
                    return parseBox;
                } catch (EOFException unused) {
                    throw new NoSuchElementException();
                } catch (IOException unused2) {
                    throw new NoSuchElementException();
                }
            }
            this.lookahead = EOF;
            throw new NoSuchElementException();
        }
        return (Box) invokeV.objValue;
    }

    @Override // com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) ? getBoxes(cls, false) : (List) invokeL.objValue;
    }

    @Override // com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, cls, z)) == null) {
            ArrayList arrayList = new ArrayList(2);
            for (Box box : getBoxes()) {
                if (cls.isInstance(box)) {
                    arrayList.add(box);
                }
                if (z && (box instanceof Container)) {
                    arrayList.addAll(((Container) box).getBoxes(cls, z));
                }
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }
}
