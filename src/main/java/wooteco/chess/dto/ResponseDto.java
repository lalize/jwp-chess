package wooteco.chess.dto;

public class ResponseDto {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;

	private int statusCode;
	private Object dto;

	public ResponseDto(int statusCode, Object dto) {
		this.statusCode = statusCode;
		this.dto = dto;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getDto() {
		return dto;
	}

	public void setDto(Object dto) {
		this.dto = dto;
	}
}
