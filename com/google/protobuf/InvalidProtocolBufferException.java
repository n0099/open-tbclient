package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.WireInput;
import java.io.IOException;
/* loaded from: classes6.dex */
public class InvalidProtocolBufferException extends IOException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1616151763072450476L;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageLite unfinishedMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidProtocolBufferException(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.unfinishedMessage = null;
    }

    public static InvalidProtocolBufferException invalidEndTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new InvalidProtocolBufferException(WireInput.PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG) : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public static InvalidProtocolBufferException invalidTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new InvalidProtocolBufferException(WireInput.PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO) : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public static InvalidProtocolBufferException invalidWireType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new InvalidProtocolBufferException("Protocol message tag had invalid wire type.") : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public static InvalidProtocolBufferException malformedVarint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.") : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public static InvalidProtocolBufferException negativeSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.") : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public static InvalidProtocolBufferException recursionLimitExceeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.") : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public static InvalidProtocolBufferException sizeLimitExceeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.") : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public static InvalidProtocolBufferException truncatedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.") : (InvalidProtocolBufferException) invokeV.objValue;
    }

    public MessageLite getUnfinishedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.unfinishedMessage : (MessageLite) invokeV.objValue;
    }

    public InvalidProtocolBufferException setUnfinishedMessage(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageLite)) == null) {
            this.unfinishedMessage = messageLite;
            return this;
        }
        return (InvalidProtocolBufferException) invokeL.objValue;
    }
}
