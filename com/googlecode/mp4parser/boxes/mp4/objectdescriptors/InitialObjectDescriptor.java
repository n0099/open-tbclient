package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class InitialObjectDescriptor extends ObjectDescriptorBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int audioProfileLevelIndication;
    public List esDescriptors;
    public List extensionDescriptors;
    public int graphicsProfileLevelIndication;
    public int includeInlineProfileLevelFlag;
    public int oDProfileLevelIndication;
    public int objectDescriptorId;
    public int sceneProfileLevelIndication;
    public List unknownDescriptors;
    public int urlFlag;
    public int urlLength;
    public String urlString;
    public int visualProfileLevelIndication;

    public InitialObjectDescriptor() {
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
        this.esDescriptors = new ArrayList();
        this.extensionDescriptors = new ArrayList();
        this.unknownDescriptors = new ArrayList();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
            this.objectDescriptorId = (65472 & readUInt16) >> 6;
            this.urlFlag = (readUInt16 & 63) >> 5;
            this.includeInlineProfileLevelFlag = (readUInt16 & 31) >> 4;
            int size = getSize() - 2;
            if (this.urlFlag == 1) {
                int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
                this.urlLength = readUInt8;
                this.urlString = IsoTypeReader.readString(byteBuffer, readUInt8);
                i = size - (this.urlLength + 1);
            } else {
                this.oDProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
                this.sceneProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
                this.audioProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
                this.visualProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
                this.graphicsProfileLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
                i = size - 5;
                if (i > 2) {
                    BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                    i -= createFrom.getSize();
                    if (createFrom instanceof ESDescriptor) {
                        this.esDescriptors.add((ESDescriptor) createFrom);
                    } else {
                        this.unknownDescriptors.add(createFrom);
                    }
                }
            }
            if (i > 2) {
                BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                if (createFrom2 instanceof ExtensionDescriptor) {
                    this.extensionDescriptors.add((ExtensionDescriptor) createFrom2);
                } else {
                    this.unknownDescriptors.add(createFrom2);
                }
            }
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "InitialObjectDescriptor{objectDescriptorId=" + this.objectDescriptorId + ", urlFlag=" + this.urlFlag + ", includeInlineProfileLevelFlag=" + this.includeInlineProfileLevelFlag + ", urlLength=" + this.urlLength + ", urlString='" + this.urlString + "', oDProfileLevelIndication=" + this.oDProfileLevelIndication + ", sceneProfileLevelIndication=" + this.sceneProfileLevelIndication + ", audioProfileLevelIndication=" + this.audioProfileLevelIndication + ", visualProfileLevelIndication=" + this.visualProfileLevelIndication + ", graphicsProfileLevelIndication=" + this.graphicsProfileLevelIndication + ", esDescriptors=" + this.esDescriptors + ", extensionDescriptors=" + this.extensionDescriptors + ", unknownDescriptors=" + this.unknownDescriptors + '}';
        }
        return (String) invokeV.objValue;
    }
}
