package example.spring.r2dbc.typeconvertor;

import org.reactive.r2dbc.iclient.type.TypeConverter;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

public class StringTypeConverter implements TypeConverter{

	@Override
	public String convert(Row row, RowMetadata rowMetadata) {
		return String.valueOf(row.get("user_id", Integer.class));
	}

}
